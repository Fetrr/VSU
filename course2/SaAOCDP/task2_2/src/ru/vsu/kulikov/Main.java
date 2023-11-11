package ru.vsu.kulikov;

import ru.vsu.kulikov.BuildPizza.*;

public class Main {
    public static void main(String[] args) {
        PizzaDirector pd = new PizzaDirector();

        PizzaBuilder margheritaBuilder = new MargheritaPizzaBuilder();
        PizzaBuilder diabloBuilder = new DiabloPizzaBuilder();

        pd.setPizzaBuilder(margheritaBuilder);
        pd.buildPizza();
        pd.getPizza().showIngredients();
        System.out.println();

        pd.setPizzaBuilder(diabloBuilder);
        pd.buildPizza();
        pd.getPizza().showIngredients();
        System.out.println();
    }
}
