package com.bankac.l.k.uygulama3.Entity.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account-collection-2")
public class Credit {
    @Field
    String TcNo;

    private int creditScore;

    private int predictWage;

    private int installment;

    private int interestRate;

    private int maxCredit;
}
