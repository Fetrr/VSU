package ru.vsu.kulikov.BuildPizza;

import ru.vsu.kulikov.Pizza;

public class DiabloPizzaBuilder extends PizzaBuilder {
    @Override
    public PizzaBuilder setDough() {
        pizza.setDough("дрожжевое");
        return this;
    }

    @Override
    public PizzaBuilder setSauce() {
        pizza.setSauce("томатный");
        return this;
    }

    @Override
    public PizzaBuilder setFilling() {
        pizza.setFillings("сыр Моцарелла", "шампиньоны", "чили", "паприка");
        return this;
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
