package RolePlayingGame;

import java.util.Random;

public class Hero extends Entity {
    private int poison;

    public Hero(String name, int hp, int strength, int agility, int gold, int xp, int poison)
    {
        super(name, hp, strength, agility, gold, xp);
        this.poison = poison;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }
}
