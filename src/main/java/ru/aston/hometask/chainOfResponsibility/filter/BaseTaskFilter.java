package ru.aston.hometask.chainOfResponsibility.filter;

import ru.aston.hometask.chainOfResponsibility.Task;

import java.util.Objects;

public abstract class BaseTaskFilter {
    protected BaseTaskFilter nextFilter;

    public BaseTaskFilter setNextHandler(BaseTaskFilter nextFilter) {
        this.nextFilter = nextFilter;
        return nextFilter;
    }

    public abstract boolean filter(Task task);

    protected boolean filterChain(Task task) {
        if (Objects.isNull(nextFilter)) {
            return true;
        }
        return nextFilter.filter(task);
    }
}
