package com.hospital.server.util;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseHelper {
    private static final Logger log = LoggerFactory.getLogger(ResponseHelper.class);
    private static final String REQ_SUCC_MSG = "请求成功";

    public ResponseHelper() {
    }

    public static <T> ResponseV2 create(T datas, int code, String msg) {
        return ResponseV2.builder().result(Data.builder().datas(datas).build()).code(code).msg(msg).build();
    }

    public static <T> ResponseV2 create(T datas) {
        return create(datas, 200, "请求成功");
    }

    public static ResponseV2 create() {
        return create((Object)null, 200, "请求成功");
    }



    public static void writeCookie(HttpServletResponse response, String cookieName, String value, String path, int maxAge, String domain) {
        Cookie cookie = new Cookie(cookieName, value);
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        response.addCookie(cookie);
    }

    public static void writeCookie(HttpServletResponse response, String cookieName, String value, String domain) {
        writeCookie(response, cookieName, value, "/", 2592000, domain);
    }


}

