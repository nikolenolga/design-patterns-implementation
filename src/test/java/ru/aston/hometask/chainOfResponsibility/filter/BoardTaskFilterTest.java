package ru.aston.hometask.chainOfResponsibility.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.aston.hometask.chainOfResponsibility.Task;

import java.util.Set;

class BoardTaskFilterTest {
    private static BoardTaskFilter boardTaskFilter;
    private static String development = "Development";
    private static String testing = "Testing";
    private static String extra = "Extra";

    @BeforeAll
    static void setUp() {
        boardTaskFilter = new BoardTaskFilter(Set.of(development, testing));
    }

    @Test
    void givenBoardTaskFilterNotContainingTaskBoardName_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = Task.builder().boardName(extra).build();
        /* when */
        boolean actual = boardTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenBoardTaskFilterContainingTaskBoardName_whenCallIsInterruptingRequired_thenReturnFalse() {
        /* given */
        Task task = Task.builder().boardName(testing).build();
        /* when */
        boolean actual = boardTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertFalse(actual);
    }

    @Test
    void givenBoardTaskFilterAndTaskWithNullBoardValue_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        Task task = new Task();
        /* when */
        boolean actual = boardTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }
}