package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.TransactionRepository;

@Component
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionRepository getTransactionRepository() {

        return transactionRepository;
    }

    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


}
