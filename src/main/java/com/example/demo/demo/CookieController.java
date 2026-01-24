package com.example.demo.demo;

import com.example.demo.pojo.DeviceInfo;
import com.example.demo.pojo.UserTest;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
 
@RestController
public class CookieController {

    @Autowired
    public RedisUtil redisUtil;


 
    @GetMapping("/get-cookie")
    public String getCookieValue(HttpServletRequest  request) {
        String key =  "cookie-key";
        String value="shavbyafbuafa";
        UserTest  userTest = new UserTest();
        userTest .setName("shaibnrfaras");

        if (redisUtil.set(key,userTest,  20)){
             return redisUtil.get(key).toString();
        }
        return "Cookie not found";
    }
}