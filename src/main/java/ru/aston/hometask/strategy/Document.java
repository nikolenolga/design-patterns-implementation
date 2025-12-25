package ru.aston.hometask.strategy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Document {
    private Long id;
    private String name;
    private String text;
}
