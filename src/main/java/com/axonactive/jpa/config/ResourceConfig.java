package com.axonactive.jpa.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("/api")
public class ResourceConfig extends Application {
    public ResourceConfig() {
        init();
    }

    private void init() {

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("0.0.1");
        beanConfig.setSchemes(new String[]{"http"});

        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/jpa/api");
//        beanConfig.setResourcePackage(Department.class.getPackage().getName());
        beanConfig.setResourcePackage("com.axonactive.jpa.controller");

        beanConfig.setTitle("RESTEasy, Swagger and Swagger UI Example");
        beanConfig.setDescription("Sample RESTful API built using RESTEasy, Swagger and Swagger UI");
        beanConfig.setScan(true);
    }
}
