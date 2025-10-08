package lessons.lesson03.BankSystem;

class BankAccount {
    String accountNumber;
    String fio;
    double balance;

    public BankAccount(String accountNumber, String fio, double balance) {
        this.accountNumber = accountNumber;
        this.fio = fio;
        this.balance = balance;
    }

    public String getInfo() {
        return "Счёт: " + accountNumber + ", Владелец: " + fio + ", Баланс: " + balance + " USD";
    }
}