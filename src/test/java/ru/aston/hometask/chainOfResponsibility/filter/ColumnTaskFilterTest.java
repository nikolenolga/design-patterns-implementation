package ru.aston.hometask.chainOfResponsibility.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.hometask.chainOfResponsibility.Task;

import java.util.Set;

class ColumnTaskFilterTest {
    private static ColumnTaskFilter columnTaskFilter;
    private static String development = "Development";
    private static String testing = "Testing";
    private static String extra = "Extra";

    @BeforeAll
    static void setUp() {
        columnTaskFilter = new ColumnTaskFilter(Set.of(development, testing));
    }

    @Test
    void givenColumnTaskFilterNotContainingTaskColumnName_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = Task.builder().columnName(extra).build();
        /* when */
        boolean actual = columnTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenColumnTaskFilterContainingTaskColumnName_whenCallIsInterruptingRequired_thenReturnFalse() {
        /* given */
        Task task = Task.builder().columnName(testing).build();
        /* when */
        boolean actual = columnTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertFalse(actual);
    }

    @Test
    void givenColumnTaskFilterAndTaskWithNullColumnValue_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = new Task();
        /* when */
        boolean actual = columnTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

}