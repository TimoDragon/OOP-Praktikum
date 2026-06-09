package Praktikum_3.items;

public class Weapon extends Item {
    private final int damage;

    public Weapon(String name, int dmg) {
        super(name);
        this.damage = dmg;
    }

    public int getDamage() {
        return this.damage;
    }
}
