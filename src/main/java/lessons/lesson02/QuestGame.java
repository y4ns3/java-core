package lessons.lesson02;

import java.util.Scanner;

// Квест игра "Тень над озером"
public class QuestGame {
    private Scanner sc;

    public QuestGame(Scanner sc) {
        this.sc = sc;
    }

    public void start(){
        scene1();
    }
    private void scene1() {
        System.out.println("Ты приходишь в себя на холодном песке у берега озера.");
        System.out.println("Вокруг — туман, ночь, ни души. Телефон в кармане почти разряжен (1%).");
        System.out.println("В другом кармане — спичка и клочок бумаги с надписью:");
        System.out.println("\"Не доверяй голосам. Иди к северу.\"");
        System.out.println("Выбор:");
        System.out.println("1. Пойти на восток, туда, где в тумане мерцает свет.");
        System.out.println("2. Пойти на север, как советует записка.");
        System.out.println("3. Остаться у озера, может, кто-то придёт.");

        int choice = sc.nextInt();
        if (choice == 1) {
            scene2A();
        } else if (choice == 2) {
            scene2B();
        } else if (choice == 3) {
            scene2C();
        } else {
            System.out.println("Неверный выбор. Попробуй снова.");
            scene1();
        }
    }

    private void scene2A() {
        System.out.println("Ты идёшь на свет и находишь старую электростанцию.");
        System.out.println("Внезапно загорается прожектор.");
        System.out.println("Голос в громкоговорителе: «Стоять. Идентификация...»");
        System.out.println("Выбор:");
        System.out.println("1. Ответить: «Я человек, я потерялся!»");
        System.out.println("2. Убежать назад в лес.");

        int choice = sc.nextInt();
        if (choice == 1) scene3A();
        else if (choice == 2) scene3B();
        else {
            System.out.println("Неверный выбор. Попробуй снова.");
            scene2A();
        }
    }

    private void scene2B() {
        System.out.println("Ты следуешь на север и находишь заброшенную деревню.");
        System.out.println("Дома пусты, но в одном — следы костра и дневник:");
        System.out.println("\"Озеро просыпается в полнолуние. Не верь голосам. Прячься до рассвета.\"");
        System.out.println("Выбор:");
        System.out.println("1. Остаться в доме до рассвета.");
        System.out.println("2. Выйти и идти дальше в туман.");

        int choice = sc.nextInt();
        if (choice == 1) scene3C();
        else if (choice == 2) scene3D();
        else {
            System.out.println("Неверный выбор. Попробуй снова.");
            scene2B();
        }
    }

    private void scene2C() {
        System.out.println("Ты остаёшься на месте. Из тумана слышишь детский голос: «Помоги мне… пожалуйста…»");
        System.out.println("Тебя охватывает страх.");
        System.out.println("Выбор:");
        System.out.println("1. Пойти на голос.");
        System.out.println("2. Убежать прочь в лес.");

        int choice = sc.nextInt();
        if (choice == 1) scene3E();
        else if (choice == 2) scene3F();
        else {
            System.out.println("Неверный выбор. Попробуй снова.");
            scene2C();
        }
    }

    private void scene3A() {
        System.out.println("Ты кричишь, но свет слепит тебя.");
        System.out.println("Из темноты появляется фигура в противогазе.");
        System.out.println("Вас усыпляют. Очнулся ты уже в лаборатории. Ты стал частью эксперимента.");
        System.out.println("Концовка: Неудача");
    }

    private void scene3B() {
        System.out.println("Ты бежишь, но спотыкаешься. Прожектор гаснет. Что-то двигается в кустах.");
        System.out.println("Ты исчез без следа.");
        System.out.println("Концовка: Неудача");
    }

    private void scene3C() {
        System.out.println("Ты сидишь у костра. Проходят часы.");
        System.out.println("На рассвете из тумана выходит группа людей — выжившие. Они помогают тебе выбраться.");
        System.out.println("Концовка: Победа");
    }

    private void scene3D() {
        System.out.println("Ты блуждаешь в тумане и выходишь к маяку. Там — старая рация.");
        System.out.println("Связь удаётся установить. На следующий день — эвакуация.");
        System.out.println("Концовка: Победа");
    }

    private void scene3E() {
        System.out.println("Ты идёшь на голос и видишь девочку в белом. Она улыбается и исчезает в воде.");
        System.out.println("Вокруг тебя — тени. Ты не можешь двигаться.");
        System.out.println("Концовка: Проклятие озера");
    }

    private void scene3F() {
        System.out.println("Ты бежишь прочь. Натыкаешься на подземный люк. Внутри — бункер.");
        System.out.println("Там — доказательства эксперимента: мониторы, карты, журналы.");
        System.out.println("Выбор:");
        System.out.println("1. Разрушить центр управления.");
        System.out.println("2. Присоединиться к проекту.");

        int choice = sc.nextInt();
        if (choice == 1) scene4A();
        else if (choice == 2) scene4B();
        else {
            System.out.println("Неверный выбор. Попробуй снова.");
            scene3F();
        }
    }

    private void scene4A() {
        System.out.println("Ты активируешь самоуничтожение. Озеро начинает светиться. Тьма уходит.");
        System.out.println("Ты спас мир… но погиб.");
        System.out.println("Концовка: Герой");
    }

    private void scene4B() {
        System.out.println("Ты входишь в проект. Тебе дают новое имя.");
        System.out.println("Ты становишься частью того, что раньше преследовало тебя.");
        System.out.println("Концовка: Тайный участник");
    }
}

