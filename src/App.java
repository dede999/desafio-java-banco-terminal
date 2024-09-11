import com.example.bank.BankAccount;

public class App {
    public static void main(String[] args) throws Exception {
        BankAccount account = BankAccount.accountCreateFromTerminal();
        System.out.println(account);
        account.deposit(25.00);
        account.withdraw(25, true);
        account.withdraw(20);
    }
}
