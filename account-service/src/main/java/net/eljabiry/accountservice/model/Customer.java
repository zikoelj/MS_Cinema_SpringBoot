package net.eljabiry.accountservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
