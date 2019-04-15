package services;

import models.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BankAccountRepository;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    public void addBankAccount(BankAccount bankAccount) {
        bankAccountRepository.insertBanckAccount(bankAccount);
    }

    public void transferMoney(String fromIban, String toIban, double amount) {
        BankAccount fromBAnkAccount = bankAccountRepository.getBankAcconut(fromIban);
        BankAccount toBankAccount = bankAccountRepository.getBankAcconut(toIban);

        if (fromBAnkAccount != null && toBankAccount != null) {
            double firstBankAccountBalance = fromBAnkAccount.getBalance();
            double toBankAccountBalance = toBankAccount.getBalance();
            fromBAnkAccount.setBalance((firstBankAccountBalance - amount));


        }
    }
}
