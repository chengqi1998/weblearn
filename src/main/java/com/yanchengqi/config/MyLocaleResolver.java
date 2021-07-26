package com.yanchengqi.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        解析请求
//      获得请求里的链接
        String language = httpServletRequest.getParameter("l");
        System.out.println("----------------"+language);
        Locale locale = Locale.getDefault();//默认的
        if(!StringUtils.isEmpty(language)){
            String[] spilt=language.split("_");
            locale=new Locale(spilt[0],spilt[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
