package ru.aston.hometask.chainOfResponsibility.filter;

import ru.aston.hometask.chainOfResponsibility.Task;

import java.util.Set;

public class ColumnTaskFilter extends BaseInterruptingTaskFilter {
    private final Set<String> columns;

    public ColumnTaskFilter(Set<String> columns) {
        this.columns = columns;
    }

    @Override
    protected boolean isInterruptingRequired(Task task) {
        return !columns.contains(task.getColumnName());
    }
}