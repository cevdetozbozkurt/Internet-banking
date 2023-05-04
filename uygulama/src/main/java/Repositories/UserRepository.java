package Repositories;

import Models.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends CouchbaseRepository<User,String> {

    User findByName(String name);
    User findByUserName(String username);
    User findByTcNo(String TcNo);
    User findByTelNo(String TelNo);









}
