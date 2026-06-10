package Praktikum_3.enemy;

import Praktikum_3.items.Item;

public class Enemy {
    private final String name;
    private final int attackDamage;
    private int firewall;
    private int systemIntegrity;
    private Item item;

    /**
     * Konstrukte des Enemies
     * @param pName Name des Enemies
     * @param pFirewall "Schild" des Gegners
     * @param pSystemIntegrity Leben des Gegners
     * @param attackDamage Attackschaden
     */
    public Enemy(String pName, int pFirewall, int pSystemIntegrity, int attackDamage) {
        this(pName, pFirewall, pSystemIntegrity, attackDamage, null);
    }

    /**
     * Konstrukte des Enemies mit Item
     * @param pName Name des Enemies
     * @param pFirewall "Schild" des Gegners
     * @param pSystemIntegrity Leben des Gegners
     * @param attackDamage Attackschaden
     * @param pItem Item des Gegners
     */
    public Enemy(String pName, int pFirewall, int pSystemIntegrity, int attackDamage, Item pItem) {
        this.name = pName;
        this.firewall = pFirewall;
        this.systemIntegrity = pSystemIntegrity;
        this.attackDamage = attackDamage;
        this.item = pItem;
    }

    /**
     * Gibt den Naemen zurück
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gibt die Total HP = firewall + systemIntegrity zurück
     * @return totalHP
     */
    public int getTotalHP() {
        return this.firewall + this.systemIntegrity;
    }

    /**
     * Funktion, welche den Gegner Schild und Leben abzieht
     * @param dmg Schaden der übergeben wird
     */
    public void takeDamage(int dmg) {
        int rest = dmg - firewall;
        firewall = Math.max(0, firewall - dmg);
        if (rest > 0)  {
            systemIntegrity -= rest;
        }
    }

    /**
     * Gibt zurück ob der Enemy noch lebt oder nicht
     * @return boolean
     */
    public boolean isDead() {
        return this.systemIntegrity <= 0;
    }

    /**
     * Gibt den Attackschaden zurück
     * @return attackDamage
     */
    public int getAttackDamage() {
        return this.attackDamage;
    }

    /**
     * Gibt den "Schild" des Gegners zurück
     * @return firewall
     */
    public int getFirewall() {
        return this.firewall;
    }

    /**
     * Gibt die Leben des Gegners zurück
     * @return systemIntegrity
     */
    public int getSystemIntegrity() {
        return this.systemIntegrity;
    }

    /**
     * gibt das Item des Gegners zurück
     * @return item
     */
    public Item getItem() {
        return this.item;
    }
}
