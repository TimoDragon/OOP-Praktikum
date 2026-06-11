package Praktikum_3.enemy;

public class EnemyVirus extends Enemy{

    public EnemyVirus(String pName, int attackDamage, int systemintegrity) {
        super(pName, attackDamage, systemintegrity);
    }

    @Override
    public int getTotalHP() {
        return 0;
    }

    @Override
    public void takeDamage(int dmg) {
        setSystemintegrity(-dmg);
    }

    @Override
    public boolean isDead() {
        return false;
    }


}
