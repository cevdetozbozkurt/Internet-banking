package com.bankac.l.k.uygulama3.Repositories;

import com.bankac.l.k.uygulama3.Entity.concretes.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
}
