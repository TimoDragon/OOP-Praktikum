package Praktikum_3.enemy;

public abstract class Enemy {
    private final String name;
    private final int attackDamage;
    private int systemintegrity;

    /**
     * Konstrukte des Enemies mit Item
     * @param pName Name des Enemies
     * @param attackDamage Attackschaden
     */
    public Enemy(String pName, int attackDamage, int systemintegrity) {
        this.name = pName;
        this.attackDamage = attackDamage;
        this.systemintegrity = systemintegrity;
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
    public abstract int getTotalHP();

    /**
     * Funktion, welche den Gegner Schild und Leben abzieht
     * @param dmg Schaden der übergeben wird
     */
    public abstract void takeDamage(int dmg);

    /**
     * Gibt zurück ob der Enemy noch lebt oder nicht
     * @return boolean
     */
    public boolean isDead() {
        return this.systemintegrity <= 0;
    }

    /**
     * Gibt den Attackschaden zurück
     * @return attackDamage
     */
    public int getAttackDamage() {
        return this.attackDamage;
    }


    /**
     *
     * @return
     */
    public int getSystemintegrity() {
        return this.systemintegrity;
    }

    /**
     *
     * @param systemintegrity
     */
    public void setSystemintegrity(int systemintegrity) {
        this.systemintegrity = systemintegrity;
    }
}
