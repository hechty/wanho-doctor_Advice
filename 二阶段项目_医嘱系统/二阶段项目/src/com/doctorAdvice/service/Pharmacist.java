package com.doctorAdvice.service;

import java.util.List;

import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.entry.rowmapper.Advice;
import com.doctorAdvice.entry.rowmapper.Drug;
import com.doctorAdvice.entry.rowmapper.User;

public class Pharmacist extends User{
	
	/**
	 * 查询所有doctor已提交的Advice
	 * @return
	 */
	public List<Advice> queryAllAdvice(){
		return Dao.queryByOne(new Advice(), TableProperties.tableStruct.getProperty("advice.status"), 
				TableProperties.tableStruct.getProperty("advice.status.doctorOk"));
	}
	
	/**
	 * 根据医嘱id查询医嘱详情
	 * @param id
	 * @return
	 */
	public Advice queryAdviceById(int id) {
		String columName = TableProperties.tableStruct.getProperty("advice.id");
		return Dao.queryByKey(new Advice(), columName, id);
	}
	
	/**
	 * 确认医嘱,设置医嘱状态为doctorOk
	 * @param id
	 */
	public void confirmAdviceById(int id, String comment) {
		Advice advice = queryAdviceById(id);
		FlowService.changeStatus(advice, this.getUserId(),TableProperties.tableStruct.getProperty("advice.status.pharmacistOk"), comment);
		
	}
	
	/**
	 * 打回医嘱,设置其状态为new
	 * @param id
	 */
	public void rollbackAdviceById(int id, String comment) {
		Advice advice = queryAdviceById(id);
		FlowService.changeStatus(advice, this.getUserId(),TableProperties.tableStruct.getProperty("advice.status.new"), comment);
	}
	
	/**
	 * 查询所有药品
	 * @return
	 */
	public List<Drug> queryAllDrugsByPage(int page){
		
		return Dao.queryAll(new Drug());
	}
	
	
}
