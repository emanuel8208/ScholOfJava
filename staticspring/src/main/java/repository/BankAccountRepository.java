package repository;

import models.BankAccount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BankAccountRepository {

    private List<BankAccount> bankAccountList = new ArrayList<>();


    public void insertBanckAccount (BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }

    public BankAccount getBankAcconut (String iBan) {
        for (BankAccount bankAccount : bankAccountList) {
            if(bankAccount.getiBan().equals(iBan)) {
                return bankAccount;
            }
        }
        return null;
    }
}
