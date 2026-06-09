package Praktikum_3;

public class User {
    private String name;
    private Inventory inventory = new Inventory();
    private int hp;


    public User(String pName) {
        this.name = pName;
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
