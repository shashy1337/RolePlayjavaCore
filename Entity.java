package RolePlayingGame;

abstract class Entity implements Fighter   {
    private String name;
    private int hp;
    private int strength;
    private int agility;
    private int gold;
    private int xp;

    public Entity(String name, int hp, int strength, int agility, int gold, int xp)
    {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.agility = agility;
        this.gold = gold;
        this.xp = xp;
    }

    @Override
    public int attack() {
        if (agility * 3 > randomValue()){
            return strength;
        } else return 0;
    }

    @Override
    public void ghrowl() {}

    public int randomValue(){
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return String.format("%s здоровье: %d", name, hp);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}
