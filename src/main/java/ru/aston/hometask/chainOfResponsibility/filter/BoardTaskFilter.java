package ru.aston.hometask.chainOfResponsibility.filter;

import ru.aston.hometask.chainOfResponsibility.Task;

import java.util.Set;

public class BoardTaskFilter extends BaseInterruptingTaskFilter {
    private final Set<String> boards;

    public BoardTaskFilter(Set<String> boards) {
        this.boards = boards;
    }

    @Override
    protected boolean isInterruptingRequired(Task task) {
        return !boards.contains(task.getBoardName());
    }
}
