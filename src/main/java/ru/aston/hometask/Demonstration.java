package ru.aston.hometask;

import ru.aston.hometask.builder.Message;

import java.time.LocalDateTime;

public class Demonstration {
    public static void main(String[] args) {
        Message message = Message.builder().id(4L)
                .isRead(false).messageDateTime(LocalDateTime.MIN)
                .addMessageText("Hello.").addMessageText("My name is ")
                .addMessageText("Olga.").build();

        System.out.println(message.getMessageText());
    }
}
