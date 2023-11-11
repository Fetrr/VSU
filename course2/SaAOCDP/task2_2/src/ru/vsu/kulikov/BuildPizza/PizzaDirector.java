package ru.vsu.kulikov.BuildPizza;

import ru.vsu.kulikov.Pizza;

public class PizzaDirector {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public void buildPizza() {
        pizzaBuilder.setDough().setSauce().setFilling();
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }
}
