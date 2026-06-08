package Praktikum_3;

public class User {
    private String name;
    private Inventory inventory = new Inventory();

    public User(String pName) {
        this.name = pName;
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}
