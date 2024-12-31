package net.eljabiry.accountservice.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.eljabiry.accountservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerservice",fallbackMethod ="getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @CircuitBreaker(name="customerservice",fallbackMethod = "getAllDefaultCustomers")
    @GetMapping("/customers")
    List<Customer> allCustomers();

      default Customer getDefaultCustomer(Long id){
         Customer customer = Customer.builder()
                 .firstName("not available")
                 .lastName("not available")
                 .email("not available")
                 .id(id)
                 .build();
         return  customer;
     }
      default List<Customer> getAllDefaultCustomers(){
         return List.of();
     }
}
