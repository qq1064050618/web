package com.moli.util;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
    public static Map<String, String> getCookieMap(Cookie[] cookie) {
        Map<String, String> map = new HashMap<>();
        if (cookie.length != 0) {
            for (Cookie cookie1 : cookie) {
                map.put(cookie1.getName(), cookie1.getValue());
            }
        }
        return map;
    }
}
