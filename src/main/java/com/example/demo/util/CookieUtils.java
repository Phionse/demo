package com.example.demo.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
public class CookieUtils {
    public static String getCookieValue(HttpServletRequest  request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}