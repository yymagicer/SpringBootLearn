package com.xzg.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.netflix.hystrix.strategy.HystrixPlugins;
import com.xzg.common.MDCHystrixConcurrencyStrategy;
import javax.net.ssl.HttpsURLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableResourceServer
@Configuration
@ComponentScan({"com.xzg.api.service", "com.xzg.common"})
public class ApiApp {

    private static final Logger LOG = LoggerFactory.getLogger(ApiApp.class);

    static {
        // 本地测试
        LOG.warn("禁用ssl主机名检查，开发截断使用");
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, sslSession) -> true);
    }

//    @Value("${app.rabbitmq.host:localhost}")
//    String rabbitMqHost;
//
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        LOG.info("Create RabbitMqCF for host: {}", rabbitMqHost);
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rabbitMqHost);
//        return connectionFactory;
//    }


    public static void main(String[] args) {
        LOG.info("Register MDCHystrixConcurrencyStrategy");
        HystrixPlugins.getInstance().registerConcurrencyStrategy(new MDCHystrixConcurrencyStrategy());
        SpringApplication.run(ApiApp.class, args);
    }
}
