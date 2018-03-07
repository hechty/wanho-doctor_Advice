package com.doctorAdvice.service;

import java.util.List;

import com.doctorAdvice.common.TableProperties;
import com.doctorAdvice.dao.ComplexDao;
import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.entry.rowmapper.Advice;
import com.doctorAdvice.entry.rowmapper.AdviceDrug;
import com.doctorAdvice.entry.rowmapper.User;


public class Doctor extends User{

	
	
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(int userId, String name, String loginName, String loginPwd, String userType) {
		super(userId, name, loginName, loginPwd, userType);
		// TODO Auto-generated constructor stub
	}

	public Doctor(User user) {
		super(user);
		// TODO Auto-generated constructor stub
	}

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
	
	/**
	 * 添加一条医嘱用药
	 * @param adviceDrug
	 * @return
	 */
	public int addAdviceDrug(AdviceDrug adviceDrug) {
		int count = 3;
		//默认存在并发问题,循环直到另一线程不对同一记录修改.
		while(count == 3) {
			count = ComplexDao.addAdviceDrug(adviceDrug);
		}
		
		return count;
	}
	
	/**
	 * 添加多条医嘱用药,返回变动记录的条数.
	 * @param adviceDrugs
	 * @return 添加失败返回0;添加成功返回adviceDrugs.size()*2;
	 */
	public int addAdviceDrugs(List<AdviceDrug> adviceDrugs) {

		
		return ComplexDao.addAdviceDrugs(adviceDrugs);
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
	 * 确认医嘱,设置医嘱状态为doctorOk
	 * @param id
	 */
	public void confirmAdviceById(int id, String comment) {
		Advice advice = queryAdviceById(id);
		FlowService.changeStatus(advice, this.getUserId(),TableProperties.tableStruct.getProperty("advice.status.doctorOk"), comment);
		
	}
	
//	/**
//	 * 根据id删除adviceDrug
//	 * @param adviceDrugId
//	 * @return
//	 */
//	public int deleteAdviceDrug(int adviceDrugId) {
//		//级联删除
//		Dao.deleteByOne(new AdviceDrug(), "id", adviceDrugId);
//	}
	
	
}
