package com.boot1.kavi.User.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot1.kavi.User.Entities.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{

	User findByUserName(String userName);

}
