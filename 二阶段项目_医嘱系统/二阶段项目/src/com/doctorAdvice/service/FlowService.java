package com.doctorAdvice.service;

import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.entry.rowmapper.Advice;

public class FlowService {

	public static void changeStatus(Advice advice, String status) {
		advice.setStatus(status);
		String columName = TableProperties.tableStruct.getProperty("advice.id");
		Dao.baseUpdate(advice, columName, advice.getAdviceId());
	}

}
