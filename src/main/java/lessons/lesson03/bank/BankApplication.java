package lessons.lesson03.bank;

public class BankApplication {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("YURIY KIM VICT","A2313121",500.75);
        bankAccount.withdraw(20.55);
        System.out.println(bankAccount.getBalance());
        bankAccount.deposit(8000);
        System.out.println(bankAccount.getBalance());
    }
}
