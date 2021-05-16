package com.ojas.controller;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

 

import com.ojas.Mvcconfigg;

 


public class FrontCtrl extends AbstractAnnotationConfigDispatcherServletInitializer{

 

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class[] {Mvcconfigg.class};
    }

 

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return null;
    }

 

    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        return new String[] {"/"};
    }

 

}
 