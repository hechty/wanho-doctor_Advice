package com.doctorAdvice.service;

import java.util.List;

import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.entry.rowmapper.Advice;
import com.doctorAdvice.entry.rowmapper.AdviceDrug;
import com.doctorAdvice.entry.user.Doctor;

public class DoctorService {
	Doctor doctor;
	
	/**
	 * 创建医嘱
	 * @param advice
	 * @return
	 */
	public int createAdvice(Advice advice) {
		return Dao.baseAdd(advice);		
	}
	
	/**
	 * 查询所有医嘱
	 * @return
	 */
	public List<Advice> queryAllAdvice(){
		return Dao.queryAll(new Advice());
	}
	
	/**
	 * 根据Id查询医嘱
	 * @param adviceId
	 * @return
	 */
	public Advice queryAdviceById(int adviceId) {
		return Dao.queryByKey(new Advice(), "id", adviceId);
	}
	
	/**
	 * 根据医嘱id,查询所有对应的用药明细
	 * @param advice
	 * @return
	 */
	public List<AdviceDrug> queryAllAdviceDrug(Advice advice){
		return Dao.queryByOne(new AdviceDrug(), "advice_id", advice.getAdviceId());
	}
	
	/**
	 * 根据Id查找AdviceDrug
	 * @param adviceDrugId
	 * @return
	 */
	public AdviceDrug queryAdviceDrugById(int adviceDrugId) {
		return Dao.queryByKey(new AdviceDrug(), "id", adviceDrugId);
	}
	
	/**
	 * 添加一条医嘱用药
	 */
	public int addAdviceDrug(AdviceDrug adviceDrug) {
		return Dao.baseAdd(adviceDrug);
	}
	
	/**
	 * 修改adciceDrug 
	 * @param adviceDrug
	 * @return
	 */
	public int updateAdviceDrug(AdviceDrug adviceDrug) {
		return Dao.baseUpdate(adviceDrug, "id", adviceDrug.getAdId());
	}
	
	/**
	 * 根据id删除adviceDrug
	 * @param adviceDrugId
	 * @return
	 */
	public int deleteAdviceDrug(int adviceDrugId) {
		//级联删除
		Dao.deleteByOne(new AdviceDrug(), "id", adviceDrugId);
	}
	
	
}
