package Praktikum_3.items;

public class Weapon extends Item {
    private final int damage;

    /**
     * Konstruktor der Klasse Weapon
     * @param name name der Waffe
     * @param dmg Wie viel Schaden die Waffe macht
     */
    public Weapon(String name, int dmg) {
        super(name);
        this.damage = dmg;
    }

    /**
     * Gibt den Schaden der Waffe zurück
     * @return damage
     */
    public int getDamage() {
        return this.damage;
    }
}
