package com.cts.CreditScoreModule.Service;

import java.util.List;
import java.util.Map;

import com.cts.CreditScoreModule.Entity.CreditTable;

public interface CreditScoreService {
	Map<String, Integer> getAllCreditScore(long userId);
	
	List<CreditTable> getAllCreditTable(long userId);
	
	int getLatestCreditScore(long userId);

}
