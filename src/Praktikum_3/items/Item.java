package Praktikum_3.items;

public abstract class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
