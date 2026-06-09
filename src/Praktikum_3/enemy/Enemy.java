package Praktikum_3.enemy;

import Praktikum_3.items.Item;

public class Enemy {
    private final String name;
    private final int attackDamage;
    private int firewall;
    private int systemIntegrity;
    private Item item;

    public Enemy(String pName, int pFirewall, int pSystemIntegrity, int attackDamage) {
        this(pName, pFirewall, pSystemIntegrity, attackDamage, null);
    }

    public Enemy(String pName, int pFirewall, int pSystemIntegrity, int attackDamage, Item pItem) {
        this.name = pName;
        this.firewall = pFirewall;
        this.systemIntegrity = pSystemIntegrity;
        this.attackDamage = attackDamage;
        this.item = pItem;
    }

    public String getName() {
        return this.name;
    }

    public int getTotalHP() {
        return this.firewall + this.systemIntegrity;
    }

    public void takeDamage(int dmg) {
        int rest = dmg - firewall;
        firewall = Math.max(0, firewall - dmg);
        if (rest > 0)  {
            systemIntegrity -= rest;
        }
    }

    public boolean isDead() {
        return this.systemIntegrity <= 0;
    }

    public int getAttackDamage() {
        return this.attackDamage;
    }

    public int getFirewall() {
        return this.firewall;
    }

    public int getSystemIntegrity() {
        return this.systemIntegrity;
    }

    public Item getItem() {
        return this.item;
    }
}
