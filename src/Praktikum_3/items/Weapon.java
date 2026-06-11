package Praktikum_3.items;

public class Weapon extends Item {
    private final int damage;
    private final float hitrate;

    /**
     * Konstruktor der Klasse Weapon
     * @param name name der Waffe
     * @param dmg Wie viel Schaden die Waffe macht
     */
    public Weapon(String name, int dmg, float hitrate) {
        super(name);
        this.damage = dmg;
        this.hitrate = hitrate;
    }

    /**
     * Gibt den Schaden der Waffe zurück
     * @return damage
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * Gibt den Hitrate der Waffe zurück
     * @return
     */
    public float getHitrate() {
        return this.hitrate;
    }
}
