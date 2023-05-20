package com.bankac.l.k.uygulama3.Repositories;

import com.bankac.l.k.uygulama3.Entity.concretes.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface UserRepository extends MongoRepository<User,String> {
    User findByUserName(String userName);

}
