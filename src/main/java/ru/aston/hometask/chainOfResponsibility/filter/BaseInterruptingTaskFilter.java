package ru.aston.hometask.chainOfResponsibility.filter;

import ru.aston.hometask.chainOfResponsibility.Task;

public abstract class BaseInterruptingTaskFilter extends BaseTaskFilter {

    protected abstract boolean isInterruptingRequired(Task task);

    @Override
    public boolean filter(Task task) {
        if (isInterruptingRequired(task)) {
            return false;
        }
        return filterChain(task);
    }
}
