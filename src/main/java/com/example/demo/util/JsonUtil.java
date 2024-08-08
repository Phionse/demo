package com.example.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.mozilla.universalchardet.UniversalDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Author: yansf
 * @Description:JSON工具类
 * @Date:Creat in 17:22 2019/12/10
 * @Modified By:
 */
public class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);
 
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
 
    /**
     * 将POJO转换为JSON
     */
    public static <T> String toJson(T obj) {
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("convert POJO to JSON failure", e);
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return json;
    }
 
    /**
     * 将JSON转为POJO
     */
    public static <T> T fromJson(String json, Class<T> type) {
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(json, type);
        } catch (IOException e) {
            LOGGER.error("convert JSON to POJO failure", e);
            throw new RuntimeException(e);
            //e.printStackTrace();
        }
        return pojo;
 
    }


    /**
     * 获得文件编码格式
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static String getFileEncode(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        String code = "utf-8";
        byte[] buf = new byte[4096];
        UniversalDetector detector = new UniversalDetector(null);

        // (2)
        int nread;
        while ((nread = in.read(buf)) > 0 && !detector.isDone()) {
            detector.handleData(buf, 0, nread);
        }
        // (3)
        detector.dataEnd();

        // (4)
        String encoding = detector.getDetectedCharset();
        if (StringUtils.isNotEmpty(encoding)) {
            code = encoding;
        }
        return code;
    }




}