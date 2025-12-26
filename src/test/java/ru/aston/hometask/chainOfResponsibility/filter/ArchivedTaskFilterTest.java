package ru.aston.hometask.chainOfResponsibility.filter;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.hometask.chainOfResponsibility.Task;

class ArchivedTaskFilterTest {
    private static ArchivedTaskFilter isArchivedTaskFilter;
    private static ArchivedTaskFilter notArchivedTaskFilter;

    @BeforeAll
    static void setUp() {
        isArchivedTaskFilter = new ArchivedTaskFilter(true);
        notArchivedTaskFilter = new ArchivedTaskFilter(false);
    }

    @Test
    void givenIsArchivedTaskFilterAndArchivedTask_whenCallIsInterruptingRequired_thenReturnFalse() {
        /* given */
        Task task = Task.builder().isArchived(true).build();
        /* when */
        boolean actual = isArchivedTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertFalse(actual);
    }

    @Test
    void givenIsArchivedTaskFilterAndNotArchivedTask_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = Task.builder().isArchived(false).build();
        /* when */
        boolean actual = isArchivedTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenNotArchivedTaskFilterAndArchivedTask_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = Task.builder().isArchived(true).build();
        /* when */
        boolean actual = notArchivedTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenNotArchivedTaskFilterAndNotArchivedTask_whenCallIsInterruptingRequired_thenReturnFalse() {
        /* given */
        Task task = Task.builder().isArchived(false).build();
        /* when */
        boolean actual = notArchivedTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertFalse(actual);
    }
}