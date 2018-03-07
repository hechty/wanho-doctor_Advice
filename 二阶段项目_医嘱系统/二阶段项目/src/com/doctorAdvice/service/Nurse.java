package com.doctorAdvice.service;

import java.util.List;

import com.doctorAdvice.common.TableProperties;
import com.doctorAdvice.dao.ComplexDao;
import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.entry.rowmapper.Advice;
import com.doctorAdvice.entry.rowmapper.AdviceDrug;
import com.doctorAdvice.entry.rowmapper.User;

public class Nurse extends User{
	
	
	public Nurse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Nurse(int userId, String name, String loginName, String loginPwd, String userType) {
		super(userId, name, loginName, loginPwd, userType);
		// TODO Auto-generated constructor stub
	}

	public Nurse(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 查询所有药剂师已审批的医嘱
	 * @return
	 */
	public String[][] queryAllAdvice(int page, int entryPerPag){
		List<Advice> list = ComplexDao.queryAnyByPage(page, entryPerPag, new Advice(), 
				TableProperties.tableStruct.getProperty("advice.status"), 
				TableProperties.tableStruct.getProperty("advice.status.pharmacistOk"));	
		return Dao.to2dArray(list);
	}
	
	/**
	 * 根据id查询医嘱详情
	 * @param id
	 * @return
	 */
	public Advice queryAdviceById(int id) {
		
		return Dao.queryByKey(new Advice(),
				TableProperties.tableStruct.getProperty("advice.id"), id);
	}
	
	
	/**
	 * 根据医嘱id,查询所有对应的用药明细
	 * @param adviceId
	 * @return
	 */
	public List<AdviceDrug> queryAllAdviceDrug(int adviceId){
		return Dao.queryByOne(new AdviceDrug(), "advice_id", adviceId);
	}
	
	/**
	 * 根据Id查找AdviceDrug
	 * @param adviceDrugId
	 * @return
	 */
	public AdviceDrug queryAdviceDrugById(int adviceDrugId) {
		return Dao.queryByKey(new AdviceDrug(), "id", adviceDrugId);
	}
}
