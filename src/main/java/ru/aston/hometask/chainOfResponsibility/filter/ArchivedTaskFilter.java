package ru.aston.hometask.chainOfResponsibility.filter;

import ru.aston.hometask.chainOfResponsibility.Task;

public class ArchivedTaskFilter extends BaseInterruptingTaskFilter {
    private final Boolean isArchived;

    public ArchivedTaskFilter(Boolean isArchivedCheck) {
        this.isArchived = isArchivedCheck;
    }

    @Override
    protected boolean isInterruptingRequired(Task task) {
        return isArchived ^ task.isArchived();
    }
}
