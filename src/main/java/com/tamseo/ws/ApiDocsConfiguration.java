package com.tamseo.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

@Profile("docs")
@Configuration
@EnableSwagger2
public class ApiDocsConfiguration {

    /**
     * Create a Docket class to be used by Springfox's Swagger API Documentation
     * framework. See http://springfox.github.io/springfox/ for more
     * information.
     * @return A Docket instance.
     */
    @Bean
    public Docket docket() {
        Predicate<String> paths = PathSelectors.ant("/api/**");

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Restonet API")
                .description(
                        "API for Restonetsystem")
                .contact("tamseo@gmail.com").version("1.0").build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo).select().paths(paths).build();

        return docket;
    }

}
