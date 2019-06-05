package com.grace.tutorials.spring.helloworld;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:/application.properties")
public class HelloWorldFromPropertyProfileConfig {


    @Value("${greetings.text}")
    private String greetingsText;


    @Bean
    @Profile("prod")
    public Worker workerForProd() {
        return new Worker("Greetings", greetingsText);
    }

    @Bean
    @Profile("dev")
    public Worker workerForDev() {
        return new Worker("Hello", greetingsText);
    }

    public class Worker {

        private String text;
        private String preamble;

        public Worker(String preamble, String text) {
            this.preamble = preamble;
            this.text = text;
        }

        public void execute() {
            System.out.println(preamble + " " + text);
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldFromPropertyProfileConfig.class);
        Worker worker = applicationContext.getBean(Worker.class);
        worker.execute();
    }
}
