package lessons.lesson03.BankSystem;

public class Main {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();

        bank.addAccount("1001", "Иванов Иван", 500.0);
        bank.addAccount("1002", "Петров Пётр", 300.0);

        bank.getAccountInfo("1001");

        bank.replenishAccount("1002", 150.0);
        bank.transferMoneyBetweenAccounts("1001", "1002", 200.0);

        bank.getAccountInfo("1001");
        bank.getAccountInfo("1002");

        bank.deleteAccount("1001");
        bank.getAccountInfo("1001");
    }
}
