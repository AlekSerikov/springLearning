package com.zaurtregulov.spring.rest.configuration;


import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //instead web.xml

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

//      <servlet>
//    <servlet-name>dispatcher</servlet-name>
//    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//    <init-param>
//      <param-name>contextConfigLocation</param-name>
//      <param-value>/WEB-INF/applicationContext.xml</param-value> //!!!!!!!!!!!!! the same as below
//    </init-param>
//    <load-on-startup>1</load-on-startup>
//  </servlet>

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MyConfiguration.class};
    }

//      <servlet-mapping>
//    <servlet-name>dispatcher</servlet-name>
//    <url-pattern>/</url-pattern> //!!!!!!!!!!!!!! the same as below
//  </servlet-mapping>

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
