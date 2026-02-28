package ru.aston.hometask.proxy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Audio {
    private Long id;
    private String name;
    private byte[] audioData;

}
