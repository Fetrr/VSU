package ru.vsu.kulikov.BuildPizza;

import ru.vsu.kulikov.Pizza;

public class MargheritaPizzaBuilder extends PizzaBuilder {
    @Override
    public PizzaBuilder setDough() {
        pizza.setDough("бездрожжевое");
        return this;
    }

    @Override
    public PizzaBuilder setSauce() {
        pizza.setSauce("томатный");
        return this;
    }

    @Override
    public PizzaBuilder setFilling() {
        pizza.setFillings("сыр Моцарелла", "базилик", "помидоры");
        return this;
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
