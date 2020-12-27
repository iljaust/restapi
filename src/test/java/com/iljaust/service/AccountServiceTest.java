package com.iljaust.service;

import com.iljaust.model.Account;
import com.iljaust.model.AccountStatus;
import com.iljaust.respository.hibernate.AccountRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock
    private AccountRepositoryImpl accountRepository;
    @InjectMocks
    private AccountService accountService;

    @Test
    void shouldGetListOfAccounts() {
        List<Account> accountList = new ArrayList<>();
        Account account = new Account();
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setData("good dev");
        account.setId(1l);

        Account account2 = new Account();
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setData("bad dev");
        account.setId(2l);

        accountList.add(account);
        accountList.add(account2);

        given(accountRepository.getAll()).willReturn(accountList);

        List<Account> expected = accountService.getAll();

        assertEquals(expected,accountList);

    }

    @Test
    void shouldUpdateAccount() {
        Account account = new Account();
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setData("good dev");
        account.setId(1l);

        given(accountRepository.update(account)).willReturn(account);

        final Account expected = accountService.update(account);

        assertThat(expected).isNotNull();

    }

    @Test
    void shouldDeleteAccountById() {
        final Long id = 1l;

        accountService.deleteById(id);
        accountService.deleteById(id);

        verify(accountRepository,times(2)).deleteById(id);
    }

    @Test
    void shouldSaveAccount() {
        Account account = new Account();
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setData("good dev");
        account.setId(1l);

        given(accountRepository.save(account)).willReturn(account);

        Account savedDeveloper = accountService.save(account);

        assertThat(savedDeveloper).isNotNull();
    }

    @Test
    void shouldFindAccountById() {
        final Long id = 1l;
        Account account = new Account();
        account.setAccountStatus(AccountStatus.ACTIVE);
        account.setData("good dev");
        account.setId(id);

        given(accountRepository.getById(id)).willReturn(account);

        final Account expected = accountService.getById(id);

        assertThat(expected).isNotNull();
    }

}