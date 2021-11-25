package com.tutorial.spring.mongodb;

        import io.cucumber.spring.CucumberContextConfiguration;
        import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(
        initializers = {SpringBootContextInitializer.class}
)
@AutoConfigureMockMvc(addFilters = false)
public class CucumberSpringConfiguration {

}
