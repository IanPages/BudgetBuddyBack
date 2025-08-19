package com.example.BudgetBuddy.service;


import com.example.BudgetBuddy.dto.account.ListAccount;
import com.example.BudgetBuddy.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    //getters (accId, userId, name)
    //post (createAccount,)
    //put (updateAccount, deleteAccount)
    //delete NO IF Balance > 0


    public ListAccount getAccountById(Integer accId) {
        return accountRepository.findById(accId)
                .map(account -> new ListAccount(
                        account.getId(),
                        account.getName(),
                        account.getBalance(),
                        account.getMainAccount(),
                        account.getGoalAmount(),
                        account.getGoalDeadline(),
                        account.getCreatedAt(),
                        account.getUser().getId()))
                .orElse(null);
    }



}
