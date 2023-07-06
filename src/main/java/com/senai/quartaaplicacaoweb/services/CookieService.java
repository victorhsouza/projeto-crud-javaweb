package com.senai.quartaaplicacaoweb.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class CookieService {

    public static void setCookie(HttpServletResponse response, String key, String valor, int segundos){
            Cookie cookie = new Cookie(key, URLEncoder.encode(valor, StandardCharsets.UTF_8));
            cookie.setMaxAge(segundos);
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request, String key){
        try{
            String valor = Optional.ofNullable(request.getCookies())
                    .flatMap(cookies -> Arrays.stream(cookies)
                            .filter(cookie -> key.equals(cookie.getName()))
                            .findAny()
                    )
                    .map(Cookie::getValue)
                    .orElse(null);

            assert valor != null;
            valor = URLDecoder.decode(valor,StandardCharsets.UTF_8);
            return valor;
        }catch (Exception e){
            return e.getMessage();
        }

    }

}
