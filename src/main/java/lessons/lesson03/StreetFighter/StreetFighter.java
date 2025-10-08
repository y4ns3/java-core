package lessons.lesson03.StreetFighter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Fighter {
    String code;
    String name;
    int health;
    int attack;

    public Fighter(String code, String name, int health, int attack) {
        this.code = code;
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public String getInfo() {
        return "Код: " + code + ", Имя: " + name + ", Здоровье: " + health + ", Урон: " + attack;
    }
}

public class StreetFighter {
    private List<Fighter> fighters = new ArrayList<>();
    private Random random = new Random();

    public void addFighter(String code, String name, int health, int attack) {
        fighters.add(new Fighter(code, name, health, attack));
        System.out.println("Боец добавлен: " + name);
    }

    public void getFighters() {
        if (fighters.isEmpty()) {
            System.out.println("Нет доступных бойцов!");
            return;
        }
        System.out.println("=== Список бойцов ===");
        for (Fighter f : fighters) {
            System.out.println(f.getInfo());
        }
    }

    public void getFighterInfo(String code) {
        for (Fighter f : fighters) {
            if (f.code.equals(code)) {
                System.out.println(f.getInfo());
                return;
            }
        }
        System.out.println("Боец не найден!");
    }

    public void fight(String code1, String code2) {
        Fighter f1 = null;
        Fighter f2 = null;

        for (Fighter f : fighters) {
            if (f.code.equals(code1)) f1 = f;
            if (f.code.equals(code2)) f2 = f;
        }

        if (f1 == null || f2 == null) {
            System.out.println("Один из бойцов не найден!");
            return;
        }

        System.out.println("=== Бой начинается! ===");
        System.out.println(f1.name + " VS " + f2.name);


        Fighter attacker = random.nextBoolean() ? f1 : f2;
        Fighter defender = (attacker == f1) ? f2 : f1;

        System.out.println("Первым атакует: " + attacker.name);


        int health1 = f1.health;
        int health2 = f2.health;

        while (health1 > 0 && health2 > 0) {
            int damage = attacker.attack + random.nextInt(6) - 3; // +-3 случайный разброс
            damage = Math.max(damage, 0);

            if (attacker == f1) {
                health2 -= damage;
                System.out.println(attacker.name + " наносит " + damage + " урона " + defender.name);
                if (health2 <= 0) break;
                attacker = f2;
                defender = f1;
            } else {
                health1 -= damage;
                System.out.println(attacker.name + " наносит " + damage + " урона " + defender.name);
                if (health1 <= 0) break;
                attacker = f1;
                defender = f2;
            }

            System.out.println("HP " + f1.name + ": " + Math.max(health1, 0) +
                " | HP " + f2.name + ": " + Math.max(health2, 0));
        }


        if (health1 > 0) {
            System.out.println("🏆 Победитель: " + f1.name + "!");
        } else {
            System.out.println("🏆 Победитель: " + f2.name + "!");
        }
        System.out.println("=====================");
    }

    public static void main(String[] args) {
        StreetFighter game = new StreetFighter();

        game.addFighter("F001", "Ryu", 100, 20);
        game.addFighter("F002", "Ken", 100, 18);
        game.addFighter("F003", "Chun-Li", 90, 22);

        game.getFighters();

        game.fight("F001", "F002");
        game.fight("F002", "F003");
    }
}
