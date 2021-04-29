package ru.ekhlusov.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ekhlusov.account.controller.model.Account;
import ru.ekhlusov.account.exception.AccountNotFoundException;
import ru.ekhlusov.account.repository.AccountRepository;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author Evgeniy Khlusov
 * 29.04.2021
 */
@Service
public class AccountService {

	private final AccountRepository accountRepository;

	@Autowired
	public AccountService(AccountRepository accountRepository) {this.accountRepository = accountRepository;}

	public Account getAccountById(Long accountId) {
		// Метод возвращает optional, по-этому если не найдено, то бросим ошибку
		return accountRepository.findById(accountId).orElseThrow(
				() -> new AccountNotFoundException("Unable to find account with ID: " + accountId)
		);
	}

	public Long createAccount(String name, String email, String phone, List<Long> bills) {
		Account account = new Account(name, email, phone, OffsetDateTime.now(), bills);
		return accountRepository.save(account).getAccountId();
	}

	public Account updateAccount(Long accountId, String name, String email, String phone, List<Long> bills) {
		Account account = new Account();
		account.setAccountId(accountId);
		account.setBills(bills);
		account.setEmail(email);
		account.setPhone(phone);
		account.setName(name);

		return accountRepository.save(account);
	}

	public Account deleteAccount(Long accountId) {
		Account deletedAccount = getAccountById(accountId);
		accountRepository.deleteById(accountId);

		return deletedAccount;
	}
}
