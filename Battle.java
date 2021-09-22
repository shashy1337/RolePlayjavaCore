package RolePlayingGame;

public class Battle {
    public void startBattle(Entity attacker, Entity defender, FightCallback callback){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int turn = 1;
                boolean isFightEnded = false;
                while (!isFightEnded){
                    System.out.println("Ход " + turn);
                    if(turn++ % 2 !=0){
                        isFightEnded = makeHit(attacker, defender, callback);
                    } else {
                        isFightEnded = makeHit(attacker, defender, callback);
                    }
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e){e.printStackTrace();}

                }
            }
        }).start();
    }

    public boolean makeHit(Entity attacker, Entity defender, FightCallback callback){
        int hit = attacker.attack();
        int defenderHealth = defender.getHp() - hit;
        if (hit != 0){
            System.out.println(String.format("%s Нанес удар в %d единиц!", attacker.getName(), hit));
            System.out.println(String.format("У %s осталось %d единиц здоровья...", defender.getName(), defenderHealth));
        } else {
            System.out.println(String.format(""));
        }
        if (defenderHealth <= 0 && defender instanceof Hero){
            System.out.println("Вы умкерли");
            callback.fightLost();
            return true;
        } else if (defenderHealth <= 0){
            System.out.println(String.format("Враг повержен!Вы получаете %d опыта и %d монет", defender.getXp(), defender.getGold()));
            attacker.setXp(attacker.getXp() + defender.getXp());
            attacker.setGold(attacker.getGold() + defender.getGold());
            callback.fightWin();
        } else
            defender.setHp(defenderHealth);
            return false;
    }
}
