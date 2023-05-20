package com.bankac.l.k.uygulama3.Controllers;

import com.bankac.l.k.uygulama3.Entity.concretes.User;
import com.bankac.l.k.uygulama3.Repositories.AccountRepository;
import com.bankac.l.k.uygulama3.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {

    private UserController userController;
    private AccountRepository accountrepo;
    private UserRepository user;

    String id = user.findByUserName(userController.getId());

    public AccountController(AccountRepository accountrepo) {
        this.accountrepo = accountrepo;
    }

    @GetMapping("/findUser/{id}")
    public Integer getUserNameById(@PathVariable String id){

        return accountrepo.findById(id).get().getBount();
    }

    }


}
