package com.univ_java_task_7.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${emd.version:1.0.0}")
    private String buildVersion;

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Railcar API")
                        .version(buildVersion)
                        .contact(new Contact()
                                .name("imitmod")
                                .email("imitmod@gmail.com")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Local service")
                ));
    }
}
