package com.ventail.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins(
                "http://localhost:3000",
                "http://ecommerce-nikki.s3-website.ca-central-1.amazonaws.com",
//                "http://ecommerce-nikki.s3-website-ap-southeast-1.amazonaws.com",
                "http://localhost:3010");
    }
}
