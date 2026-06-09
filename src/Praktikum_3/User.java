package Praktikum_3;

import Praktikum_3.items.Weapon;

public class User {
    private String name;
    private Inventory inventory = new Inventory();
    private int hp = 200;

    public User(String pName) {
        this.name = pName;

        getInventory().addItem(new Weapon("Digitale Faust", 50));
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public void takeDamage(int dmg) {
        if (hp > 0) {
            this.hp -= dmg;
        }
    }

    public int getHP() {
        return this.hp;
    }

    public boolean isDead() {
        return this.hp <= 0;
    }
}
