package com.bankac.l.k.uygulama3.Repositories;

import com.bankac.l.k.uygulama3.Entity.concretes.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User,String> {


}
