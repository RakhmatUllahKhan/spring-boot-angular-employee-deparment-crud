package com.myProject.myProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api.*"), regex("/api/department.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("myProjet API")
				.description("myProject API reference for testing:1=>add deparment without employee.2=>add Employee without Manager.3=>Now add new empoyee"
						+ "whose manager can any emplyee that is added First.")
				.licenseUrl("rakhmatnamal@gmail.com").version("1.0").build();
	}

}
