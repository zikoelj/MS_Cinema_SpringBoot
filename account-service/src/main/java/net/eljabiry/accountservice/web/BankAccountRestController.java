package net.eljabiry.accountservice.web;

import net.eljabiry.accountservice.clients.CustomerRestClient;
import net.eljabiry.accountservice.entities.BankAccount;
import net.eljabiry.accountservice.model.Customer;
import net.eljabiry.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class BankAccountRestController {

    private final BankAccountRepository bankAccountRepository;
    private final CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepository bankAccountRepository
            ,CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }



 /*   @GetMapping("/accounts")
    public List<BankAccount> accountList(){
       return bankAccountRepository.findAll();
    }*/



 @GetMapping("/accounts")
 public List<BankAccount> accountList() {
     List<BankAccount> lba = bankAccountRepository.findAll();
     List<Customer> lc = customerRestClient.allCustomers();
     for (BankAccount ba : lba) {
         for (Customer c : lc) {
             if (c.getId() == ba.getCustomerId()) {
                 ba.setCustomer(c);
                 break;
             }
         }
     }
     return lba;
 }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
