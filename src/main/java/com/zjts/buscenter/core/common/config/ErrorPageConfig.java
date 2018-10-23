package com.zjts.buscenter.core.common.config;


import org.springframework.boot.web.server.AbstractConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ErrorPageConfig {
    @Bean
    public WebServerFactoryCustomizer embeddedServletContainerCustomizer() {
        return new MyCustomizer();
    }

    private static class MyCustomizer implements WebServerFactoryCustomizer {

        @Override
        public void customize(WebServerFactory factory) {
            AbstractConfigurableWebServerFactory acwf = (AbstractConfigurableWebServerFactory) factory;
            acwf.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html"));
            acwf.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/error/404.html"));
        }

    }
}
