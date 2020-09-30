package com.andersenlab.spring;

import com.andersenlab.server.EmbeddedTomcat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {
    @Bean
    public EmbeddedTomcat getTomcat(){
        return new EmbeddedTomcat();
    }
}
