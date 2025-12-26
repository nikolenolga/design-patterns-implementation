package ru.aston.hometask.chainOfResponsibility.filter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.aston.hometask.chainOfResponsibility.Task;

class BaseInterruptingTaskFilterTest {
    private BaseInterruptingTaskFilter returningTrueInterruptingTaskFilter = new BaseInterruptingTaskFilter() {
        @Override
        protected boolean isInterruptingRequired(Task task) {
            return true;
        }
    };
    private BaseInterruptingTaskFilter returningFalseInterruptingTaskFilter = new BaseInterruptingTaskFilter() {
        @Override
        protected boolean isInterruptingRequired(Task task) {
            return false;
        }
    };
    private Task task = new Task();

    @Test
    void givenFilterChainWithFirstReturningTrueFilterAndSecondReturningFalseFilter_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        returningFalseInterruptingTaskFilter.setNextHandler(null);
        returningTrueInterruptingTaskFilter.setNextHandler(returningFalseInterruptingTaskFilter);
        /* when */
        boolean actual = returningTrueInterruptingTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

    @Test
    void givenFilterChainWithFirstReturningFalseFilterAndSecondReturningTrueFilter_whenCallIsInterruptingRequired_thenReturnTrue() {
        /* given */
        returningTrueInterruptingTaskFilter.setNextHandler(null);
        returningFalseInterruptingTaskFilter.setNextHandler(returningTrueInterruptingTaskFilter);
        /* when */
        boolean actual = returningTrueInterruptingTaskFilter.isInterruptingRequired(task);
        /* then */
        Assertions.assertTrue(actual);
    }

}