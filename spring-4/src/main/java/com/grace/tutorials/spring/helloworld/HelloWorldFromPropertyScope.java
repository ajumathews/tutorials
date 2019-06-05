package com.grace.tutorials.spring.helloworld;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:/application.properties")
public class HelloWorldFromPropertyScope {


    @Value("${greetings.text}")
    private String greetingsText;


    @Bean
    @Scope("prototype")
    public Worker worker(){
        return new Worker(greetingsText);
    }

    public class Worker{

        private String text;

        public Worker(String text){
            this.text = text;
            System.out.println("Instance Created");
        }

        public void execute(){
            System.out.println("Hello "+ text);
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldFromPropertyScope.class);
        Worker worker = applicationContext.getBean(Worker.class);
        worker.execute();
        Worker worker2 = applicationContext.getBean(Worker.class);
        worker2.execute();
    }
}
