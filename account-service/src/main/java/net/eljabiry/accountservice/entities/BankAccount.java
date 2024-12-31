package net.eljabiry.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.eljabiry.accountservice.enums.AccountType;
import net.eljabiry.accountservice.model.Customer;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "Account_table")
public class BankAccount {
@Id //@GeneratedValue(strategy = GenerationType.IDENTITY) i use UUID
    private String accountId;
    private Double solde;
    private LocalDate createdAt;
    private String device;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;


}

