package ru.aston.hometask.chainOfResponsibility.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.hometask.chainOfResponsibility.Task;

class CompletionTaskFilterTest {
    private static CompletionTaskFilter isCompletionTaskFilter;
    private static CompletionTaskFilter notCompletionTaskFilter;

    @BeforeAll
    static void setUp() {
        isCompletionTaskFilter = new CompletionTaskFilter(true);
        notCompletionTaskFilter = new CompletionTaskFilter(false);
    }

    @Test
    void givenIsCompletionTaskFilterAndCompletedTask_whenCallIsInterruptingRequired_thenReturnFalse() {
        /* given */
        Task task = Task.builder().isCompleted(true).build();
        /* when */
        boolean actual = isCompletionTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertFalse(actual);
    }

    @Test
    void givenIsCompletionTaskFilterAndNotCompletedTask_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = Task.builder().isCompleted(false).build();
        /* when */
        boolean actual = isCompletionTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenNotCompletionTaskFilterAndCompletedTask_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = Task.builder().isCompleted(true).build();
        /* when */
        boolean actual = notCompletionTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenNotCompletionTaskFilterAndNotCompletedTask_whenCallIsInterruptingRequired_thenReturnFalse() {
        /* given */
        Task task = Task.builder().isCompleted(false).build();
        /* when */
        boolean actual = notCompletionTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertFalse(actual);
    }

}