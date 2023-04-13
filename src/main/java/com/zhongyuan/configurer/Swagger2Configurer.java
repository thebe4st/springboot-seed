package com.zhongyuan.configurer;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;

@EnableOpenApi
@Configuration
public class Swagger2Configurer {

    // http://localhost:8000/swagger-ui/index.html
    @Bean
    public Docket regDocket() {
        return new Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))

            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Swagger3接口文档")
            .description("更多请咨询服务开发者。")
            .contact(new Contact("敢敢。", "", "a71z@qq.com"))
            .version("1.0")
            .build();
    }
}
