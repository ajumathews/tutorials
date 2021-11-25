package com.tutorial.spring.mongodb;

import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringBootContextInitializer implements ApplicationContextInitializer  <ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

        TestContainerSetup.initTestContainers(configurableApplicationContext.getEnvironment());

        TestPropertyValues values = TestPropertyValues.of(
                             "spring.data.mongodb.uri=" + TestContainerSetup.getMongoDBContainerUri(),
                "security.ignored=/**"
        );

        values.applyTo(configurableApplicationContext);
    }
}