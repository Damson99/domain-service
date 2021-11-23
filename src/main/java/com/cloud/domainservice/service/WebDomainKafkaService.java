package com.cloud.domainservice.service;

import com.cloud.domainservice.model.WebDomain;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
@EnableAutoConfiguration
public class WebDomainKafkaService {

    @Bean
    public Consumer<KStream<String, WebDomain>> domainService() {

        return inputStream -> inputStream.foreach((key, value) -> {

            log.info("web domain consumed: {}, status: {}", value.getDomain(), value.isDead());
        });
    }
}
