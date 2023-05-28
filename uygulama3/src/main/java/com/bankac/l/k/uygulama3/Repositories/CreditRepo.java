package com.bankac.l.k.uygulama3.Repositories;

import com.bankac.l.k.uygulama3.Entity.concretes.Credit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CreditRepo extends MongoRepository<Credit, Integer> {
}
