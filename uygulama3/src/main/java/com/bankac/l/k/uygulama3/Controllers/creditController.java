package com.bankac.l.k.uygulama3.Controllers;

import com.bankac.l.k.uygulama3.Entity.concretes.Account2;
import com.bankac.l.k.uygulama3.Entity.concretes.Credit;
import com.bankac.l.k.uygulama3.Repositories.CreditRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class creditController {
    @Autowired
    private CreditRepo creditRepo;

    @Bean




    @PostMapping("/calculate")
    public int creditScore(Credit credit,int wage){

        int score= wage*12/100;
        int maxCredit= score*10000;
        credit.setMaxCredit(maxCredit);
        credit.setCreditScore(score);
        creditRepo.save(credit);
        return score;
    }




}
