package ru.vsu.kulikov.BuildPizza;

import ru.vsu.kulikov.Pizza;

public abstract class PizzaBuilder {
    Pizza pizza;
    public PizzaBuilder() {
        pizza = new Pizza();
    }
    abstract PizzaBuilder setDough();
    abstract PizzaBuilder setSauce();
    abstract PizzaBuilder setFilling();

    Pizza getPizza() {
        return pizza;
    }
}
