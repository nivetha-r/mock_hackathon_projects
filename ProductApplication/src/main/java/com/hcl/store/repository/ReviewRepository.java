package com.hcl.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.store.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	Object findByStoreId(int i);

}
