package Praktikum_3.enemy;

public class Enemy {
    private final String name;
    private int firewall;
    private int systemIntegrity;

    public Enemy(String pName, int pFirewall, int pSystemIntegrity) {
        this.name = pName;
        this.firewall = pFirewall;
        this.systemIntegrity = pSystemIntegrity;
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

    public int getFirewall() {
        return  this.firewall;
    }

    public int getSystemIntegrity() {
        return this.systemIntegrity;
    }
}
