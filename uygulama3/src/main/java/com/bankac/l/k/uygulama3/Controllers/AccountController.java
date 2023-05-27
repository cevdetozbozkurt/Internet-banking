package com.bankac.l.k.uygulama3.Controllers;

import com.bankac.l.k.uygulama3.Entity.concretes.Account2;
import com.bankac.l.k.uygulama3.Entity.concretes.User;
import com.bankac.l.k.uygulama3.Repositories.Account2Repo;
import com.bankac.l.k.uygulama3.Repositories.AccountRepository;
import com.bankac.l.k.uygulama3.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AccountController {

    @Autowired
    private Account2Repo account2Repo;

    private Account2 activeAccount;
    @PostMapping("/signin")
    public String signIn(@RequestBody Account2 account2){
        boolean exist = false;
        List<Account2> accountList = account2Repo.findAll();
        for(Account2 account: accountList){
            if(account2.getTCKN().equals(account.getTCKN())){
                exist = true;
                break;
            }
        }
        if(!exist){
            account2Repo.save(account2);
            return "User has created," + account2.getName() + " " + account2.getSurname();
        }else {
            return "TCKN daha once kayitli oldugu icin islem basarisiz.";
        }
    }

    @PostMapping("/login")
    public String login(String Tckno, String password){
        List<Account2> accountList = account2Repo.findAll();
        boolean succesful = false;
        for(Account2 account: accountList){
            if(account.getTCKN().equals(Tckno)  && account.getPassword().equals(password)){
                activeAccount = account;
                succesful = true;
                return "true ya girdi";
            }else{
                succesful = false;
                return "false a girdi";
            }
        }
        if (succesful){
            return "giris basarili";
        }else {
            return "Tckno veya sifreyi kontrol ediniz.";
        }
    }


    @PostMapping("/sendmoney")
    public String sendMoney(int money, Account2 sender ,Account2 buyer, String Iban){
        activeAccount = sender;

        List<Account2> accountList = account2Repo.findAll();
        for(Account2 account: accountList){
            if(account.getIBAN().equals(Iban)){
                buyer = account;
                break;
            }
        }
        if(sender.getBalance()>=money){
            sender.setBalance(sender.getBalance()-money);
            buyer.setBalance(sender.getBalance()+money);
            return "Mevcut bakiye: " + sender.getBalance();
        }else{
            return "Bakiyeniz yetersiz oldugu icin odeme gerceklestirilemedi.";
        }
    }


    @GetMapping("/getAllAccount")
    public List<Account2> getAllAccounts(){
        return account2Repo.findAll();
    }

    @GetMapping("/getAccount/{id}")
    public String getAccountById(@RequestBody String id){
        /*
        if(account2Repo.existsById(id)){
            return "Name: " + account2Repo.findById(id).get().getName() + "\n" +
                    "Surname: " + account2Repo.findById(id).get().getSurname()+ "\n"+
                    "Balance: " + account2Repo.findById(id).get().getBalance() + " TL" + "\n" +
                    "Debt: " + account2Repo.findById(id).get().getDebt() +" TL" + "\n" +
                    "IBAN: " + account2Repo.findById(id).get().getIBAN();
        }
        else{
            return "There is no such account";
        }

         */
        return "Name: " + account2Repo.findById(id).get().getName() + "\n" +
                "Surname: " + account2Repo.findById(id).get().getSurname()+ "\n"+
                "Balance: " + account2Repo.findById(id).get().getBalance() + " TL" + "\n" +
                "Debt: " + account2Repo.findById(id).get().getDebt() +" TL" + "\n" +
                "IBAN: " + account2Repo.findById(id).get().getIBAN();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAccount(@PathVariable String id){
        if(account2Repo.findById(id).get().getDebt() == 0){
            account2Repo.deleteById(id);
            return "Account deleted successfully";
        }else if(account2Repo.findById(id).get().getDebt() > 0){
            return "Account could not be deleted, your debt must be paid";
        }else {
            return "Procces failed.";
        }
    }

}
