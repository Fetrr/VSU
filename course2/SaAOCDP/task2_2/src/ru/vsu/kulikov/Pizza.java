package ru.vsu.kulikov;

public class Pizza {
    private String dough;
    private String sauce;
    private String[] fillings;

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setFillings(String ... fillings) {
        this.fillings = fillings;
    }

    public void showIngredients() {
        System.out.println("Dough: " + dough + "\t");
        System.out.println("Sauce: " + sauce + "\t");
        System.out.print("Filling: ");
        if (fillings != null) {
            for (int i = 0; i < fillings.length - 1; i++) {
                System.out.print(fillings[i] + ", ");
            }
            System.out.println(fillings[fillings.length - 1]);
        } else System.out.println("null");
    }
}
