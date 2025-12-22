package ru.aston.hometask.builder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@ToString
@Getter
@EqualsAndHashCode
public final class Message implements Cloneable {
    private final Long id;
    private final MessageType type;
    private final String messageText;
    private final LocalDateTime messageDateTime;
    private final String messageSenderName;
    private final String messageReceiverName;
    private final Integer priority;
    private final Locale language;
    private final Boolean isRead;
    private final List<String> attachments;

    Message(Long id, MessageType type, String messageText,
            LocalDateTime messageDateTime, String messageSenderName,
            String messageReceiverName, Integer priority,
            Locale language, Boolean isRead,
            @NonNull List<String> attachments) {
        this.id = id;
        this.type = type;
        this.messageText = messageText;
        this.messageDateTime = messageDateTime;
        this.messageSenderName = messageSenderName;
        this.messageReceiverName = messageReceiverName;
        this.priority = priority;
        this.language = language;
        this.isRead = isRead;
        this.attachments = new ArrayList<>(attachments);
    }

    Message(Message other) {
        this.id = other.id;
        this.type = other.type;
        this.messageText = other.messageText;
        this.messageDateTime = other.messageDateTime;
        this.messageSenderName = other.messageSenderName;
        this.messageReceiverName = other.messageReceiverName;
        this.priority = other.priority;
        this.language = other.language;
        this.isRead = other.isRead;
        this.attachments = new ArrayList<>(other.attachments);
    }

    public static MessageBuilder builder() {
        return new MessageBuilder();
    }

    public List<String> getAttachments() {
        return List.copyOf(attachments);
    }

    @Override
    public Message clone() {
        return new Message(this);
    }
}
