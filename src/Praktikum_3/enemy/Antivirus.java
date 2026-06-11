package Praktikum_3.enemy;

public class Antivirus extends Enemy{

    public Antivirus(String pName, int attackDamage, int systemintegrity) {
        super(pName, attackDamage,systemintegrity);
    }


    @Override
    public int getTotalHP() {
        return getSystemintegrity();
    }

    @Override
    public void takeDamage(int dmg) {
       setSystemintegrity(-dmg);
    }

}
