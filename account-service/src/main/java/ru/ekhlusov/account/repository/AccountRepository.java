package ru.ekhlusov.account.repository;

import org.springframework.data.repository.CrudRepository;
import ru.ekhlusov.account.controller.model.Account;

/**
 * @author Evgeniy Khlusov
 * 29.04.2021
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

}
