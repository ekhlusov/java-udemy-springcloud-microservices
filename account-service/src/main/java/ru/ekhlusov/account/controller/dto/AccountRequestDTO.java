package ru.ekhlusov.account.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author Evgeniy Khlusov
 * 29.04.2021
 */

@Getter
@NoArgsConstructor
public class AccountRequestDTO {
	private String         name;
	private String         phone;
	private String         email;
	private OffsetDateTime creationDate;
	private List<Long>     bills;
}
