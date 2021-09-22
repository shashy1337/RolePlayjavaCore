package RolePlayingGame;


import java.util.Scanner;

public class World {

    private static Scanner scanner;
    private static Hero entityPlayer = null;
    private static Battle battle = null;
    private static String getCommand;


    public static void main(String[] args) {

            scanner = new Scanner(System.in);
            battle = new Battle();
            System.out.println("Добро пожаловать в рпг");
            commands();
            theJourneyBegins(scanner.nextLine());



    }

    public static void theJourneyBegins(String command) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (entityPlayer == null) {
                    entityPlayer = new Hero("George", 250, 50, 10, 0, 0, 0);
                    System.out.println(String.format("ваш герой создан под именем %s", entityPlayer.getName()));
                }
                    switch (command) {
                        case "1" -> {
                            System.out.println("Добро пожаловать в мой магазин!Хотите ли что нибудь купить?да/нет");
                            String request = scanner.nextLine();
                            if (request.equalsIgnoreCase("да")){
                                Shoper.buyPoison(entityPlayer);
                                System.out.println(String.format("Вы купили зелье. Кол-во зельев %d", entityPlayer.getPoison()));
                                System.out.println("Спасибо за покупку!");
                                commands();
                                System.out.print("Введите следующую команду: ");
                                getCommand = scanner.nextLine();
                                theJourneyBegins(getCommand);
                            } else {
                                System.out.print("Прощай друг!: ");
                                getCommand = scanner.nextLine();
                                theJourneyBegins(getCommand);
                            }

                        }
                        case "2" -> {
                            System.out.println("А вот и первый slave в dungeon!");
                            goFight();
                        }
                        case "3" -> {
                            System.out.print("Вы точно хотите выйти?да/нет?");
                            String getAnswer = scanner.nextLine();
                            if (getAnswer.equalsIgnoreCase("да")) {
                                System.exit(1);
                            } else {
                                getCommand = scanner.nextLine();
                                theJourneyBegins(getCommand);
                            }
                        }
                    }
                }
        }).start();
    }

    public static void goFight() {
        battle.startBattle(entityPlayer, createMonsters(), new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("Вы победили монстра %s! Теперь у вас %d золота, а также осталось %d здоровья",
                        entityPlayer.getName(), entityPlayer.getGold(), entityPlayer.getHp()));
                commands();
                String getCommand = scanner.nextLine();
                theJourneyBegins(getCommand);
            }

            @Override
            public void fightLost() {

            }
        });
    }

    private static void commands() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1.Торговец");
        System.out.println("2.В темный лес");
        System.out.println("3.Выход");
    }

    public static Entity createMonsters() {
        int random = (int) (Math.random() * 10);
        if (random % 2 == 0) {
            return new Skelet("skeleton", 20, 1, 2, 3, 10);
        } else
            return new Goblin("hobgob", 30, 5, 4, 10, 10);
    }
}
