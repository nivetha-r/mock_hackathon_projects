package com.hcl.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.store.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findUserByUserNameAndPassWord(String userName,String passWord);

	public User findUserByUserId(Integer userId);

	

}
