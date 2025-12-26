package ru.aston.hometask.chainOfResponsibility;

import ru.aston.hometask.chainOfResponsibility.filter.*;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class ChainOfResponsibilityDemonstration {
    private static final String[] BOARD_ARRAY = {"Documentation", "Development", "Testing", "Personal"};
    private static final String[] COLUMN_ARRAY = {"To do", "In progress", "Testing", "Done"};
    private static final Set<String> BOARD_SET = Set.of("Development", "Testing", "Extra");
    private static final Set<String> COLUMN_SET = Set.of("In progress", "Testing", "Extra");
    private static final LocalDateTime[] DEADLINE_ARRAY = {LocalDateTime.now(), LocalDateTime.MIN, LocalDateTime.MAX};

    public static void demonstrateChainOfResponsibility() {
        CompletionTaskFilter taskFilterChain = createDemonstraitionTaskFilterChain();
        generateRandomTasksStream().filter(taskFilterChain::filter)
                .toList()
                .forEach(System.out::println);
    }

    private static CompletionTaskFilter createDemonstraitionTaskFilterChain() {
        CompletionTaskFilter rootTaskFilter = new CompletionTaskFilter(false);
        rootTaskFilter.setNextHandler(new ArchivedTaskFilter(false))
                .setNextHandler(new TopLevelTaskFilter())
                .setNextHandler(new DeadlineTaskFilter(LocalDateTime.now(), true))
                .setNextHandler(new BoardTaskFilter(BOARD_SET))
                .setNextHandler(new ColumnTaskFilter(COLUMN_SET));
        return rootTaskFilter;
    }

    private static Stream<Task> generateRandomTasksStream() {
        return Stream.iterate(1, n -> n + 1)
                .limit(100)
                .map(ChainOfResponsibilityDemonstration::createRandomTask);
    }

    private static Task createRandomTask(Integer i) {
        Random random = new Random();
        int columnNumber = random.nextInt(COLUMN_ARRAY.length);
        int boardNumber = random.nextInt(BOARD_ARRAY.length);
        int deadlineNumber = random.nextInt(3);
        Task parentTask = random.nextInt(2) % 2 == 0 ? null : new Task();
        boolean isArchived = random.nextInt(2) % 2 == 0;
        boolean isCompleted = random.nextInt(2) % 2 == 0;

        return Task.builder()
                .id((long) i)
                .title("Title" + i)
                .description("Description" + i)
                .parentTask(parentTask)
                .isArchived(isArchived)
                .isCompleted(isCompleted)
                .boardName(BOARD_ARRAY[boardNumber])
                .columnName(COLUMN_ARRAY[boardNumber])
                .deadline(DEADLINE_ARRAY[deadlineNumber])
                .build();
    }
}
