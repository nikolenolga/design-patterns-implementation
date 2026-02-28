package ru.aston.hometask.chainOfResponsibility.filter;

import ru.aston.hometask.chainOfResponsibility.Task;

public class CompletionTaskFilter extends BaseInterruptingTaskFilter {
    private final Boolean isCompleted;

    public CompletionTaskFilter(Boolean isCompletedCheck) {
        this.isCompleted = isCompletedCheck;
    }

    @Override
    protected boolean isInterruptingRequired(Task task) {
        return isCompleted ^ task.isCompleted();
    }
}
