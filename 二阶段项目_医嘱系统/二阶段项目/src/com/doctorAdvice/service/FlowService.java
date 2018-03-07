package com.doctorAdvice.service;

import java.util.Date;

import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.entry.rowmapper.Advice;
import com.doctorAdvice.entry.rowmapper.AdviceFlow;


public class FlowService {

	public static void changeStatus(Advice advice, int userId,String status, String comment) {
		advice.setStatus(status);
		String columName = TableProperties.tableStruct.getProperty("advice.id");
		//更新数据库advice状态
		Dao.baseUpdate(advice, columName, advice.getAdviceId());
		//创建一个新的adviceFlow对象,编号为0,插入数据库是使用自动生成的id
		AdviceFlow as = new AdviceFlow(advice.getAdviceId(), comment, userId, status, new Date(),0);
		//数据库中增加新的流程记录
		Dao.baseAdd(as);
	}

}
