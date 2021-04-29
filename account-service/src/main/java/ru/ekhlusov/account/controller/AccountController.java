package ru.ekhlusov.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ekhlusov.account.controller.dto.AccountRequestDTO;
import ru.ekhlusov.account.controller.dto.AccountResponseDTO;
import ru.ekhlusov.account.service.AccountService;

/**
 * @author Evgeniy Khlusov
 * 29.04.2021
 */

@RestController
public class AccountController {

	private final AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("/{accountId}")
	public AccountResponseDTO getAccount(@PathVariable Long accountId) {
		return new AccountResponseDTO(accountService.getAccountById(accountId));
	}

	@PostMapping("/")
	public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {
		return accountService.createAccount(
				accountRequestDTO.getName(),
				accountRequestDTO.getEmail(),
				accountRequestDTO.getPhone(),
				accountRequestDTO.getBills()
		);
	}

	@PutMapping("/{accountId}")
	public AccountResponseDTO updateAccount(@PathVariable Long accountId,
											@RequestBody AccountRequestDTO accountRequestDTO) {
		return new AccountResponseDTO(accountService.updateAccount(accountId, accountRequestDTO.getName(),
				accountRequestDTO.getEmail(), accountRequestDTO.getPhone(), accountRequestDTO.getBills()));
	}

	@DeleteMapping("/{accountId")
	public AccountResponseDTO deleteAccount(@PathVariable Long accountId) {
		return new AccountResponseDTO(accountService.deleteAccount(accountId));
	}
}
