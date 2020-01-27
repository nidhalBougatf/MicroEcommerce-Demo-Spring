package com.ecommerce.microecommerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // specifying that this class is used to replace a classic xml configuration file
@EnableSwagger2 
public class SwaggerConfig {

    @Bean
    public Docket api() // this method is used to configure all
    {
        return new Docket(DocumentationType.SWAGGER_2) //specifying which version of swagger we will use
                .select() // to initialize ApiSelectorBuilder class so that we can use many useful methods later
                .apis(RequestHandlerSelectors.basePackage("com.ecommerce.microecommerce.web.controller"))
                                                    // RequestHandlerSelector is used to filter documentation according to our needs
                                                    // other useful methods : basePackage ( filter by package) , annotationPresent ( filter only methods having that annotation )
                                                    // in this case , we'll document only files included in web.controller package ( which contains our APIs)
                .paths(PathSelectors.regex("/products.*")) // filter according paths, in this case we will document paths starting with ../products...
                .build();
    }
}
