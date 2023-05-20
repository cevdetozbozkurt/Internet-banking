package com.bankac.l.k.uygulama3.Entity.concretes;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "spring-boot-collection")
public class User {

    @Id
    private String id;
    private String name;
    private String userName;
    private String password;
    private String number;

}
