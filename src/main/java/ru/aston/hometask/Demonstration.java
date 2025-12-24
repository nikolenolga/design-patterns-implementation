package ru.aston.hometask;

import ru.aston.hometask.builder.Message;
import ru.aston.hometask.chainOfResponsibility.ChainOfResponsibilityDemonstration;

import java.time.LocalDateTime;

public class Demonstration {
    public static void main(String[] args) {
        demonstrateBuilder();
        demonstrateChainOfResponsibility();
    }

    public static void demonstrateBuilder() {
        System.out.println("BUILDER PATTERN: build message");
        Message message = Message.builder().id(4L)
                .messageDateTime(LocalDateTime.MIN)
                .addMessageText("Hello. ").addMessageText("My name is ")
                .addMessageText("Olga.").build();
        System.out.println(message);
    }

    public static void demonstrateChainOfResponsibility() {
        System.out.println("CHAIN OF RESPONSIBILITY PATTERN: create filter chain and filter stream of 100 random tasks");
        ChainOfResponsibilityDemonstration.demonstrateChainOfResponsibility();
    }

}
