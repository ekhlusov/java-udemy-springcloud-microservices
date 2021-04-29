package ru.ekhlusov.account.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.ekhlusov.account.controller.model.Account;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author Evgeniy Khlusov
 * 29.04.2021
 */

// Lomboc - полезные методы
@Getter
@AllArgsConstructor
public class AccountResponseDTO {

	private Long           accountId;
	private String         name;
	private String         phone;
	private String         email;
	private OffsetDateTime creationDate;
	private List<Long>     bills;

	public AccountResponseDTO(Account account) {
		accountId = account.getAccountId();
		name = account.getName();
		email = account.getEmail();
		phone = account.getPhone();
		creationDate = account.getCreationDate();
		bills = account.getBills();
	}
}
