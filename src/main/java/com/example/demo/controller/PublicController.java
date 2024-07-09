package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.example.demo.server.BroadcastingFormalService;
import com.example.demo.util.HttpTest1;
import com.example.demo.util.PagePro;
import com.example.demo.util.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author Mr.ma.com
 * @explain
 * @date 2021/7/2 11:17
 */
@Slf4j
@RestController
@RequestMapping("/Public")
public class PublicController {


    @Autowired
    public BroadcastingFormalService broadcastingFormalService;


    @PostMapping("/getMenus")
    public ResultView getMenus(int num,int size){
        PagePro pagePro = new PagePro();
        pagePro.setPageNum(num);
        pagePro.setPageSize(size);
        return ResultView.success(broadcastingFormalService.process(pagePro));
    }


    @PostMapping("/uploadShpAndGetInfo")
    public void uploadShpAndGetInfo(@RequestParam MultipartFile multipartFile) throws Exception {
        String fileName = multipartFile.getOriginalFilename();
        if (StrUtil.isNotBlank(fileName)) {
            String fileType = fileName.split("[.]")[1];
            if (fileType.endsWith("zip")) {
                // 不是以.shp结尾的文件
                log.error("上传的文件格式只能是.shp文件和.zip压缩包!");
            } else {
                //临时保存路径
                String filename = multipartFile.getOriginalFilename();
                String shpFileTempUrl = "D:/tmp";
                String path = shpFileTempUrl + StrUtil.SLASH + filename;
                //目录是否存在 不存在就创建
                if (!FileUtil.exist(shpFileTempUrl)) {
                    FileUtil.mkdir(shpFileTempUrl);
                }
                //创建文件
                File file = FileUtil.file(path);
                if(!fileType.endsWith("zip")){
                    //解压
                    File unzip = ZipUtil.unzip(multipartFile.getInputStream(), file, CharsetUtil.CHARSET_UTF_8);
                    //获取以.shp结尾的文件
                    List<File> shp = FileUtil.loopFiles(unzip, pathname -> pathname.getName().endsWith("shp"));
                    HttpTest1.getShapeFile(shp.get(1));
                }

            }
        } else {
            log.error("文件不能为空!");
        }
    }



}
