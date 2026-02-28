package ru.aston.hometask.chainOfResponsibility.filter;

import ru.aston.hometask.chainOfResponsibility.Task;

import java.time.LocalDateTime;
import java.util.Objects;

public class DeadlineTaskFilter extends BaseInterruptingTaskFilter {
    private final LocalDateTime deadlineBoundary;
    private final Boolean isBefore;

    public DeadlineTaskFilter(LocalDateTime deadlineBoundary, Boolean isBefore) {
        this.deadlineBoundary = deadlineBoundary;
        this.isBefore = isBefore;
    }

    @Override
    protected boolean isInterruptingRequired(Task task) {
        LocalDateTime deadline = task.getDeadline();
        return Objects.isNull(deadline) || isDeadlineOutOfBoundary(deadline);
    }

    private boolean isDeadlineOutOfBoundary(LocalDateTime deadline) {
        return isBefore ^ deadline.isBefore(deadlineBoundary);
    }
}
