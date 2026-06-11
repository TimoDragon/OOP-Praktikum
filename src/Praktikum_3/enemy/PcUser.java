package Praktikum_3.enemy;

import Praktikum_3.items.Item;

public class PcUser extends Enemy {
    private int firewall;
    private Item item;

    public PcUser(String pName, int attackDamage, int systemintegrity, int firewall, Item item) {
        super(pName, attackDamage, systemintegrity);
        this.firewall = firewall;
        this.item = item;
    }

    @Override
    public int getTotalHP() {
        return this.firewall + this.getSystemintegrity();
    }

    @Override
    public void takeDamage(int dmg) {
        int rest = Math.max(0, dmg - firewall);
        firewall = Math.max(0, firewall - dmg);
        if (rest > 0) {
            setSystemintegrity(Math.max(0, getSystemintegrity() - rest));
        }
    }

    @Override
    public boolean isDead() {
        return this.getTotalHP() <= 0;
    }

    public int getFirewall() {
        return this.firewall;
    }

    public Item getItem() {
        return this.item;
    }
}
