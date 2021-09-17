package RolePlayingGame;

public  class Monster extends Entity{


    public Monster(String name, int hp, int strength, int agility, int gold, int xp)
    {

        super(name, hp, strength, agility, gold, xp);
    }

    @Override
    public void ghrowl() {
        System.out.println("AAAARGH!");
    }
}
