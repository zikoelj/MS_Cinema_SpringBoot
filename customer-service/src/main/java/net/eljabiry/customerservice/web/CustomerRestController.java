package net.eljabiry.customerservice.web;


import net.eljabiry.customerservice.entities.Customer;
import net.eljabiry.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    private final CustomerRepository customerRepository;

    public CustomerRestController(CustomerRepository customerRepository
            ) {
        this.customerRepository = customerRepository;

    }


    @GetMapping("/customers")
    public List<Customer> customerList(){
     return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer customerById(@PathVariable Long id){
            return customerRepository.findById(id).get();
    }



}
