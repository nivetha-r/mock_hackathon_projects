package com.hcl.parking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.parking.entity.AvailableSlot;

@Repository
public interface AvailableSlotsRepository extends JpaRepository<AvailableSlot, Integer>{

	public AvailableSlot save(AvailableSlot availableSlot);

	public List<AvailableSlot> findByAvailableDate(LocalDate now);

	@Query("SELECT s FROM AvailableSlot s WHERE s.availableslotId= :availableslotId and s.status='Available'")
	AvailableSlot lockingSlot(@Param("availableslotId") int availableslotId);

}
