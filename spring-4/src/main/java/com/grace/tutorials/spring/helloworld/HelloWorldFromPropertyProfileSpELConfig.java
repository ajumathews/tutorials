package com.grace.tutorials.spring.helloworld;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:/application-${spring.profiles.active}.properties")
public class HelloWorldFromPropertyProfileSpELConfig {


    @Value("${greetings.text}")
    private String greetingsText;

    @Value("${greetings.preamble}")
    private String premable;


    @Value("#{new Boolean(environment['spring.profiles.active']=='dev')}")
    private boolean isDev;

    @Bean
    public Worker worker() {
        return new Worker(premable, greetingsText);
    }

    public class Worker {

        private String text;
        private String preamble;

        public Worker(String preamble, String text) {
            this.preamble = preamble;
            this.text = text;
        }

        public void execute() {
            System.out.println(preamble + " " + text + " isDev ="+isDev );
        }
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloWorldFromPropertyProfileSpELConfig.class);
        Worker worker = applicationContext.getBean(Worker.class);
        worker.execute();
    }
}
