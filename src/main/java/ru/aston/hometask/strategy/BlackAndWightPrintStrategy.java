package ru.aston.hometask.strategy;

public class BlackAndWightPrintStrategy implements PrintStrategy {

    @Override
    public void print(Document document) {
        System.out.printf("Print text in black and wight: %s%n", document.getText());
    }
}
