package Praktikum_3.user;

import Praktikum_3.items.Weapon;

public class User {
    private String name;
    private Inventory inventory = new Inventory();
    private int hp = 200;

    /**
     * Konstruktor der Klasse User
     * @param pName name
     */
    public User(String pName) {
        this.name = pName;

        getInventory().addItem(new Weapon("Digitale Faust", 50));
    }

    /**
     * Gibt das Inventar des users zurück
     * @return
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Zieht dem User Leben ab, anhand des übergebenen Damage
     * @param dmg
     */
    public void takeDamage(int dmg) {
        if (hp > 0) {
            this.hp -= dmg;
        }
    }

    /**
     * Gibt die HP zurück
     * @return
     */
    public int getHP() {
        return this.hp;
    }

    /**
     * Gibt zurück ob der User noch HP hat oder nicht
     * @return
     */
    public boolean isDead() {
        return this.hp <= 0;
    }

    /**
     * Gibt den Name des Users zurück
     * @return
     */
    public String getName() {
        return this.name;
    }
}
