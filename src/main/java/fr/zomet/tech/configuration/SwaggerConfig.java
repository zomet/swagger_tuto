package fr.zomet.tech.configuration;

import com.fasterxml.classmate.TypeResolver;
import fr.zomet.tech.dtos.ContactMedium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    @Autowired
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(new BasicAuth("basicAuth")))
                .useDefaultResponseMessages(false)
                .protocols(Collections.singleton("HTTP"))
                .additionalModels(typeResolver.resolve(ContactMedium.class))
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.zomet.tech"))
                .paths(PathSelectors.ant("/v*/**"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Swagger UI",
                "Generated swagger from default api-docs",
                "1.1",
                "",
                new Contact("mac carthy", "http://mac.carthy.org", "mac.carthy@ctu.org"),
                "apache",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }

    @Bean
    @Primary
    public SwaggerResourcesProvider swaggerResourcesProvider(InMemorySwaggerResourcesProvider inMemorySwaggerResourcesProvider) {
        return () -> {
            List<SwaggerResource> swaggerResources = new ArrayList<>(inMemorySwaggerResourcesProvider.get());
            swaggerResources.add(customSwaggerResource());
            return swaggerResources;
        };
    }

    private SwaggerResource customSwaggerResource() {
        SwaggerResource customSwaggerResource = new SwaggerResource();
        customSwaggerResource.setName("Custom swagger spec");
        customSwaggerResource.setSwaggerVersion("1.0");
        customSwaggerResource.setLocation("/custom-swagger.json");
        return customSwaggerResource;
    }

}
