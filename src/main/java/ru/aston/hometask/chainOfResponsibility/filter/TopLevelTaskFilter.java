package ru.aston.hometask.chainOfResponsibility.filter;

import ru.aston.hometask.chainOfResponsibility.Task;

import java.util.Objects;

public class TopLevelTaskFilter extends BaseInterruptingTaskFilter {

    @Override
    protected boolean isInterruptingRequired(Task task) {
        return Objects.nonNull(task.getParentTask());
    }
}
