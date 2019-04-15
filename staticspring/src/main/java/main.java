import Config.ProjectConfig;
import models.BankAccount;
import services.BankAccountService;
import services.TransactionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
           // TransactionService transactionService = context.getBean(TransactionService.class);
            //System.out.println(transactionService);

            BankAccount bankAccount1 = new BankAccount();
            bankAccount1.setiBan("1");
            bankAccount1.setOwnerName("Jhoe Doe");
            bankAccount1.setBalance(500.00);

            BankAccount bankAccount2 = new BankAccount();
            bankAccount2.setBalance(300.00);
            bankAccount2.setOwnerName("Alex");
            bankAccount2.setiBan("2");

            BankAccountService bankAccountService = context.getBean(BankAccountService.class);

            bankAccountService.addBankAccount(bankAccount1);
            bankAccountService.addBankAccount(bankAccount2);

            System.out.println(bankAccount1.toString());
            System.out.println(bankAccount2.toString());

            bankAccountService.transferMoney("1","2",200);


        }

    }
}
