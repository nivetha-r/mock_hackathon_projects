package com.hcl.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.google.common.base.Optional;
import com.hcl.parking.entity.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, String> {

	 public Optional<Registration> findByUserName(String userName);

	public java.util.Optional<Registration> findByRegistrationId(Integer registrationId);

	//public Optional<Registration> findById(Integer registrationId);
	 

}
