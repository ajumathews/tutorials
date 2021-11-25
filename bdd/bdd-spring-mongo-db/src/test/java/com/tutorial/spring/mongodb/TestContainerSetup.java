package com.tutorial.spring.mongodb;

import org.springframework.core.env.ConfigurableEnvironment;
import org.testcontainers.containers.MongoDBContainer;

public class TestContainerSetup {



    private static final int MONGODB_PORT = 27017;
    private static final String MONGODB_IMAGE = "mongo";



    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer(MONGODB_IMAGE)
            .withExposedPorts(MONGODB_PORT);

    static void initTestContainers(ConfigurableEnvironment configEnv) {
        mongoDBContainer.start();
    }



    public static String getMongoDBContainerUri() {
        return mongoDBContainer.getReplicaSetUrl();
    }
}