package RolePlayingGame;

public class Shoper {

    private Hero buyer;


    public static void buyPoison(Hero buyer){
        if (buyer.getGold() >= 30){
            buyer.setGold(buyer.getGold() - 30);
            buyer.setPoison(buyer.getPoison() + 1);
        } else {
            System.out.println("недостаточно денег!");
        }
    }
}
