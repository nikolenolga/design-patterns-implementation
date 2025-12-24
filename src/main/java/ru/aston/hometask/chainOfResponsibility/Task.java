package ru.aston.hometask.chainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private Task parentTask;
    private String boardName;
    private String columnName;
    private String title;
    private String description;
    private LocalDateTime deadline;
    private boolean isCompleted;
    private boolean isArchived;
}
