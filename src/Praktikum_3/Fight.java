package Praktikum_3;

import Praktikum_3.enemy.Enemy;

public class Fight {
    private final User user;
    private final Enemy enemy;

    public Fight(User user, Enemy enemy) {
        this.user = user;
        this.enemy = enemy;
    }

    public boolean isUserWinner() {
        return this.enemy.isDead();
    }

    public boolean fightActive() {
        while (false == this.user.isDead() && false == this.enemy.isDead()) {


        }
        return false;
    }
}
