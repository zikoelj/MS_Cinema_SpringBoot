package net.eljabiry.accountservice;

import net.eljabiry.accountservice.clients.CustomerRestClient;
import net.eljabiry.accountservice.entities.BankAccount;
import net.eljabiry.accountservice.enums.AccountType;
import net.eljabiry.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository,
										CustomerRestClient customerRestClient) {
		return args -> {
				BankAccount bankAccount1 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.device("MAD")
						.solde(Math.random()*874664)
						.type(AccountType.CURRENT_ACCOUNT)
						.createdAt(LocalDate.now())
						.customerId(1L)
						.build();
				BankAccount bankAccount2 = BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.device("EUR")
						.solde(Math.random()*879655)
						.type(AccountType.SAVING_ACCOUNT)
						.createdAt(LocalDate.now())
						.customerId(2L)
						.build();
				bankAccountRepository.save(bankAccount1);
				bankAccountRepository.save(bankAccount2);

		};
	}
}
