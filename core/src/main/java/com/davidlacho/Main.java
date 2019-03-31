package com.davidlacho;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("Guess the number game");
//        create context (container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //        get game bean from context (container)
        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class );

//        call method next() to get a random number
        int number = numberGenerator.next();

//        call method next() to get a random number
        log.info("number = {}", number );

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        log.info("getMainMessage = {}", messageGenerator.getMainMessage());
        log.info("getResultMessage = {}", messageGenerator.getResultMessage());

//        close the context
        context.close();
    }
}
