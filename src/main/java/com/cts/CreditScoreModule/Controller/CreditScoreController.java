package com.cts.CreditScoreModule.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.CreditScoreModule.Entity.CreditTable;
import com.cts.CreditScoreModule.Entity.ResponseMessage;
import com.cts.CreditScoreModule.Service.CreditScoreService;

@RestController
@CrossOrigin("*")
public class CreditScoreController {
	@Autowired
	private CreditScoreService service;
	
	
	@GetMapping(value="score/{userId}")
	public ResponseEntity<Object> getCreditScoreMonths(@PathVariable("userId") long userId){
		ResponseEntity<Object> response=null;
		List<CreditTable> list = service.getAllCreditTable(userId);
		ResponseMessage rs = new ResponseMessage();
		List<String> mons = new ArrayList<>();
 		List<Integer> scores = new ArrayList<>();
		for (CreditTable creditTable : list) {
			mons.add(creditTable.getMonths());
			scores.add(creditTable.getCreditScore());
		}
		Collections.reverse(mons);
		Collections.reverse(scores);
		rs.setScores(scores.toArray(new Integer[0]));
		rs.setMonths(mons.toArray(new String[0]));
		System.out.println(rs.getMonths());
		response=ResponseEntity.status(200).body(rs);
		return response;
	}
	
	@GetMapping(value="score/latest/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public int getLatestScore(@PathVariable("userId") long userId) {
		Map<String,Integer> map=new HashMap<>();
		map.put("creditScore", service.getLatestCreditScore(userId));
		return service.getLatestCreditScore(userId);
	}
	

}
