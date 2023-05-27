package com.bankac.l.k.uygulama3.Entity.concretes;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "account-collection-2")

public class Account2 {
    @Id
    private String id;

    private String name;
    private String surname;
    private String TCKN;
    private String password;
    private String IBAN;
    private int balance;
    private float debt;

}
