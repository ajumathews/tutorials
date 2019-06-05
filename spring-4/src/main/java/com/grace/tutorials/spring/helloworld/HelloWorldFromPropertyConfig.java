package com.grace.tutorials.spring.helloworld;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class HelloWorldFromPropertyConfig {


    @Value("${greetings.text}")
    private String greetingsText;


    @Bean
    public Worker worker(){
        return new Worker(greetingsText);
    }

    public class Worker{

        private String text;

        public Worker(String text){
            this.text = text;
        }

        public void execute(){
            System.out.println("Hello "+ text);
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldFromPropertyConfig.class);
        Worker worker = applicationContext.getBean(Worker.class);
        worker.execute();
    }
}
