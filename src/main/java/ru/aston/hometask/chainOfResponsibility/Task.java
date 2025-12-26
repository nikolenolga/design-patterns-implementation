package ru.aston.hometask.chainOfResponsibility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
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
