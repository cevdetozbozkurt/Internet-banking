package com.bankac.l.k.uygulama3.Controllers;

import com.bankac.l.k.uygulama3.Entity.concretes.Account2;
import com.bankac.l.k.uygulama3.Repositories.Account2Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

import java.util.List;
import java.util.Random;


@RestController
public class AccountController {

    @Autowired
    private Account2Repo account2Repo;

    private Account2 activeAccount;
    Random random = new Random();

    public String createIBAN(){
        String Iban = "TR ";
        for(int i = 0; i < 5; i++){
            Iban += random.nextInt(10);

        }
        return Iban;
    }


    String name= "ahmet";
    String surname = "ekmel";
    String pass="123456";
    String tckno="5";
    String iban= "TR 27664";


    @PostMapping("/signin")
    public String signIn(@RequestBody Account2 account2,String name,String surname, String password, String Tckno){
        password= this.pass;
        name=this.name;
        surname=this.surname;
        Tckno=this.tckno;

        account2.setName(name);
        account2.setSurname(surname);
        account2.setPassword(password);
        account2.setTCKN(Tckno);
        account2.setIBAN(iban);
        boolean existIban = true;
        List<Account2> accountList1 = account2Repo.findAll();
        int i=0;
        while(existIban){
                if (account2.getIBAN().equals(accountList1.get(i).getIBAN())) {
                    existIban = true;
                    account2.setIBAN(createIBAN());
                    i = 0;
                }else if(!account2.getIBAN().equals(accountList1.get(i).getIBAN()) && i< accountList1.size()-1){
                    i++;
                }else{
                    existIban=false;
                }
        }

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
    boolean succesful;


    //frontendden parametre alip atanacak
    String Tckno="2";
    String password = "123456";
    @PostMapping("/login")
    public String login(String Tckno, String password){
        List<Account2> accountList = account2Repo.findAll();
        password = this.password;
        Tckno = this.Tckno;
        for(Account2 account: accountList){
            if(account.getTCKN().equals(Tckno)  && account.getPassword().equals(password)){
                activeAccount = account;
                succesful = true;
            }
        }
        if (succesful){
            return "giris basarili";
        }else {
            return "Tckno veya sifreyi kontrol ediniz.";
        }
    }

    //frontendden parametre alip atanacak
    int money1 = 99;
    @PutMapping("/sendmoney")
    public String sendMoney(Account2 sender , Account2 buyer, String Iban, String money){
        sender = activeAccount;
        Iban = "TR 1234567890";
        money = String.valueOf(money1);
        List<Account2> accountList = account2Repo.findAll();
        for(Account2 account: accountList){
            if(account.getIBAN().equals(Iban)){
                buyer = account;

            }
        }
        System.out.println(buyer.getIBAN());
        int money1=Integer.parseInt(money);
        if(sender.getBalance() >= money1){
            sender.setBalance(sender.getBalance()-money1);
            buyer.setBalance(buyer.getBalance()+money1);
            account2Repo.save(sender);
            account2Repo.save(buyer);
            return "Mevcut bakiye: " + sender.getBalance();
        }else{
            return "Bakiyeniz yetersiz oldugu icin odeme gerceklestirilemedi.";
        }

    }


    @GetMapping("/getAllAccount")
    public List<Account2> getAllAccounts(){
        return account2Repo.findAll();
    }

    @GetMapping("/getAccount/{tckno}")
    public String getAccountById(@RequestBody String tckno){

        tckno = activeAccount.getTCKN();
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

        //duzeltilecek ------>
        return "Name: " + account2Repo.findById(tckno).get().getName() + "\n" +
                "Surname: " + account2Repo.findById(tckno).get().getSurname()+ "\n"+
                "Balance: " + account2Repo.findById(tckno).get().getBalance() + " TL" + "\n" +
                "Debt: " + account2Repo.findById(tckno).get().getDebt() +" TL" + "\n" +
                "IBAN: " + account2Repo.findById(tckno).get().getIBAN();
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
