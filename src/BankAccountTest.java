import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankAccountTest {

    @Test
    void tDeposit() {
        BankAccount account = new BankAccount();
        account.deposit(10);
        Assertions.assertEquals(10, account.getBalance());
    }

    @Test
    public void tWithdraw() {
        BankAccount account = new BankAccount();
        account.deposit(50);
        account.withdraw(20);
        Assertions.assertEquals(30, account.getBalance());
    }

    @Test
    public void tTransfer() {
        BankAccount sender = new BankAccount();
        BankAccount recipient = new BankAccount();
        sender.deposit(100);
        sender.transfer(recipient, 50);
        Assertions.assertEquals(50, sender.getBalance());
        Assertions.assertEquals(50, recipient.getBalance());
    }
}