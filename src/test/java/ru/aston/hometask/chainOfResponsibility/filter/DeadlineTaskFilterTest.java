package ru.aston.hometask.chainOfResponsibility.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.hometask.chainOfResponsibility.Task;

import java.time.LocalDateTime;

class DeadlineTaskFilterTest {
    private static DeadlineTaskFilter isBeforeDeadlineTaskFilter;
    private static DeadlineTaskFilter isAfterDeadlineTaskFilter;

    @BeforeAll
    static void setUp() {
        isBeforeDeadlineTaskFilter = new DeadlineTaskFilter(LocalDateTime.now(), true);
        isAfterDeadlineTaskFilter = new DeadlineTaskFilter(LocalDateTime.now(), false);
    }

    @Test
    void givenIsBeforeDeadlineTaskFilterAndTaskWithBeforeDeadline_whenCallIsInterruptingRequired_thenReturnFalse() {
        /* given */
        Task task = Task.builder().deadline(LocalDateTime.MIN).build();
        /* when */
        boolean actual = isBeforeDeadlineTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertFalse(actual);
    }

    @Test
    void givenIsBeforeDeadlineTaskFilterAndTaskWithAfterDeadline_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = Task.builder().deadline(LocalDateTime.MAX).build();
        /* when */
        boolean actual = isBeforeDeadlineTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenIsAfterDeadlineTaskFilterAndTaskWithBeforeDeadline_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = Task.builder().deadline(LocalDateTime.MIN).build();
        /* when */
        boolean actual = isAfterDeadlineTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenIsAfterDeadlineTaskFilterAndTaskWithAfterDeadline_whenCallIsInterruptingRequired_thenReturnFalse() {
        /* given */
        Task task = Task.builder().deadline(LocalDateTime.MAX).build();
        /* when */
        boolean actual = isAfterDeadlineTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertFalse(actual);
    }

}