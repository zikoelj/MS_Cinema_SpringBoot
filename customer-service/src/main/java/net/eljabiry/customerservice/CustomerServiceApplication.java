package net.eljabiry.customerservice;

import net.eljabiry.customerservice.entities.Customer;
import net.eljabiry.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication 
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args ->{
			List<Customer> customerList = List.of(
					 Customer.builder()
							.firstName("ziko")
							.lastName("elj")
					        .email("zikoelj@email.com")
							.build(),
			         Customer.builder()
							.firstName("hamza")
							.lastName("sbr")
					        .email("hamzasbr@email.com")
					        .build()
			);
			customerRepository.saveAll(customerList);
		};
	}
}
