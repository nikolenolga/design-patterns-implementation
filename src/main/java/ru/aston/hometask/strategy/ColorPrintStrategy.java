package ru.aston.hometask.strategy;

public class ColorPrintStrategy implements PrintStrategy {

    @Override
    public void print(Document document) {
        System.out.printf("Print text in color: %s%n", document.getText());
    }
}
