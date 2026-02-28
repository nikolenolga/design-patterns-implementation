package ru.aston.hometask.strategy;

public class MonochromePrintStrategy implements PrintStrategy {

    @Override
    public void print(Document document) {
        System.out.printf("Print text in monochrome: %s%n", document.getText());
    }
}
