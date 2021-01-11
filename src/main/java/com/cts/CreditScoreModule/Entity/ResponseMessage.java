package com.cts.CreditScoreModule.Entity;

import java.util.List;

import lombok.Data;

@Data
public class ResponseMessage {

	private int status;
	private String[] months;
	private Integer[] scores;
}
