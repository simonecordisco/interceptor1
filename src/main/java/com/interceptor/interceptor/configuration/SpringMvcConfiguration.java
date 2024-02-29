package com.interceptor.interceptor.configuration;

import com.interceptor.interceptor.interceptor.APILogginingInterceptor;
import com.interceptor.interceptor.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Component
@SpringBootApplication
public class SpringMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private APILogginingInterceptor apiLogginingInterceptor;
    @Autowired
    private TestInterceptor testInterceptor;

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcConfiguration.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Registra l'intercettatore di logging API
        registry.addInterceptor(apiLoggingInterceptor());

        // Registra l'intercettatore legacy per l'endpoint /legacy
        registry.addInterceptor(legacyInterceptor())
                .addPathPatterns("/legacy");
    }

    @Bean
    public APILogginingInterceptor.APILoggingInterceptor apiLoggingInterceptor() {
        return new APILogginingInterceptor.APILoggingInterceptor();
    }

    @Bean
    public HandlerInterceptor legacyInterceptor() {
        return new APILogginingInterceptor.APILoggingInterceptor();
    }
}

