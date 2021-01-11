package com.cts.CreditScoreModule.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.CreditScoreModule.Entity.CreditTable;
import com.cts.CreditScoreModule.Repository.CreditScoreRepository;

@Service
public class CreditScoreServiceImpl implements CreditScoreService{
	@Autowired
	private CreditScoreRepository dao;
	
/*	public CreditTable findByCreditId(int creditId) {
		Optional<CreditTable> optional = dao.findById(creditId);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
*/
	@Override
	public Map<String, Integer> getAllCreditScore(long userId) {

		return(dao.findByUserId(userId).stream().collect(Collectors.toMap(CreditTable::getMonths, CreditTable::getCreditScore)));

	}
	@Override
	public int getLatestCreditScore(long userId) {
		// TODO Auto-generated method stub
		Map<String,Integer> map= new HashMap<>();
		map=dao.findByUserId(userId).stream().collect(Collectors.toMap(CreditTable::getMonths, CreditTable::getCreditScore));
		for (String months : map.keySet()) {
			if(months.equalsIgnoreCase(LocalDate.now().getMonth().toString()))
				return map.get(months);
			
		}
		return 0;
	}
	
	public List<CreditTable> getAllCreditTable(long userId){
		List<CreditTable> list = dao.findByUserId(userId);
		return list;
	}
}
