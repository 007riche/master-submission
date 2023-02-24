package com.example.springcourse.firstspringmvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MainWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
       // return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class <?> [] {AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
//        return new String[0];
        return new String [] {"/"};
    }
}
