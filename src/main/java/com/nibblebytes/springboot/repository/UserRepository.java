package com.nibblebytes.springboot.repository;

import com.nibblebytes.springboot.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository //2.0'dan sonra buna gerek yok. Zaten repositoryden extends ettik.
public interface UserRepository extends MongoRepository<User, String> {  //String userin id'si'


}
