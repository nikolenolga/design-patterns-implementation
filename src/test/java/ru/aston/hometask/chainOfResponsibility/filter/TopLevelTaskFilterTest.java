package ru.aston.hometask.chainOfResponsibility.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.hometask.chainOfResponsibility.Task;

class TopLevelTaskFilterTest {
    private static TopLevelTaskFilter topLevelTaskFilter;

    @BeforeAll
    static void setUp() {
        topLevelTaskFilter = new TopLevelTaskFilter();
    }

    @Test
    void givenTopLevelTaskFilterAndTaskWithParentTask_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = Task.builder().parentTask(new Task()).build();
        /* when */
        boolean actual = topLevelTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenTopLevelTaskFilterAndTaskWithoutParentTask_whenCallIsInterruptingRequired_thenReturnFalse() {
        /* given */
        Task task = new Task();
        /* when */
        boolean actual = topLevelTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertFalse(actual);
    }

}