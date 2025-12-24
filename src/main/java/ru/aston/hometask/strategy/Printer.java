package ru.aston.hometask.strategy;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
public class Printer {
    private final Map<String, PrintStrategy> STRATEGY = new HashMap<>();
    private String standardStrategyKey;

    public Printer() {
        STRATEGY.put(StrategyKey.COLOR, new ColorPrintStrategy());
        STRATEGY.put(StrategyKey.MONOCHROME, new MonochromePrintStrategy());
        STRATEGY.put(StrategyKey.BLACK_AND_WIGHT, new BlackAndWightPrintStrategy());
        this.standardStrategyKey = StrategyKey.BLACK_AND_WIGHT;
    }

    public void print(String strategyKey, Document document) {
        STRATEGY.get(strategyKey).print(document);
    }

    public void print(Document document) {
        STRATEGY.get(standardStrategyKey).print(document);
    }

}
