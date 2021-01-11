package com.cts.CreditScoreModule.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cts.CreditScoreModule.Entity.CreditTable;

@CrossOrigin("*")
public interface CreditScoreRepository extends JpaRepository<CreditTable, Integer>{
	List<CreditTable> findByUserId(long userId);
}
