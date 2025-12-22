package ru.aston.hometask.builder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class MessageBuilder {
    private final StringBuilder messageTextBuilder = new StringBuilder();
    private final List<String> attachments = new ArrayList<>();
    private Long id;
    private MessageType type;
    private LocalDateTime messageDateTime;
    private String messageSenderName;
    private String messageReceiverName;
    private Integer priority;
    private Locale language;
    private Boolean isRead;

    public MessageBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public MessageBuilder type(MessageType type) {
        this.type = type;
        return this;
    }

    public MessageBuilder addMessageText(String messageText) {
        this.messageTextBuilder.append(messageText);
        return this;
    }

    public MessageBuilder messageDateTime(LocalDateTime messageDateTime) {
        this.messageDateTime = messageDateTime;
        return this;
    }

    public MessageBuilder messageSenderName(String messageSenderName) {
        this.messageSenderName = messageSenderName;
        return this;
    }

    public MessageBuilder messageReceiverName(String messageReceiverName) {
        this.messageReceiverName = messageReceiverName;
        return this;
    }

    public MessageBuilder priority(Integer priority) {
        this.priority = priority;
        return this;
    }

    public MessageBuilder language(Locale language) {
        this.language = language;
        return this;
    }

    public MessageBuilder isRead(Boolean isRead) {
        this.isRead = isRead;
        return this;
    }

    public MessageBuilder addAttachment(String attachment) {
        this.attachments.add(attachment);
        return this;
    }

    public MessageBuilder addAttachments(List<String> attachments) {
        this.attachments.addAll(attachments);
        return this;
    }

    public Message build() {
        if (Objects.isNull(type)) {
            type = MessageType.NONE;
        }

        if (Objects.isNull(messageDateTime)) {
            messageDateTime = LocalDateTime.now();
        }

        return new Message(id, type, messageTextBuilder.toString(),
                messageDateTime, messageSenderName, messageReceiverName,
                priority, language, isRead, attachments);
    }
}
