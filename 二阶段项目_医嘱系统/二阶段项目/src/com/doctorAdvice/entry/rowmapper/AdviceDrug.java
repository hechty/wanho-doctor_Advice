package com.doctorAdvice.entry.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.doctorAdvice.common.TableName;
import com.doctorAdvice.dao.RowMapper;

public class AdviceDrug 
	implements RowMapper<AdviceDrug>{
	public static final String tableName = TableName.adviceDrug;
	private int adId;
	private int drugInventy;
	private int drugCount;
	private int adviceId;
	public AdviceDrug() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdviceDrug(int adId, int drugInventy, int drugCount, int adviceId) {
		super();
		this.adId = adId;
		this.drugInventy = drugInventy;
		this.drugCount = drugCount;
		this.adviceId = adviceId;
	}
	public int getAdId() {
		return adId;
	}
	public void setAdId(int adId) {
		this.adId = adId;
	}
	public int getDrugInventy() {
		return drugInventy;
	}
	public void setDrugInventy(int drugInventy) {
		this.drugInventy = drugInventy;
	}
	public int getDrugCount() {
		return drugCount;
	}
	public void setDrugCount(int drugCount) {
		this.drugCount = drugCount;
	}
	public int getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(int adviceId) {
		this.adviceId = adviceId;
	}
	@Override
	public AdviceDrug rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		
		int nadId;
		int ndrugInventy;
		int ndrugCount;
		int nadviceId;
		
		try {
			nadId = rs.getInt(1);
			ndrugInventy = rs.getInt(2);
			ndrugCount = rs.getInt(3);
			nadviceId = rs.getInt(4);
			return new AdviceDrug(nadId, ndrugInventy, ndrugCount, nadviceId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public Object[] getProperty() {
		// TODO Auto-generated method stub
		Object[] obj = {adId, drugInventy, drugCount, adviceId};
		return obj;
	}
	@Override
	public String getSqlFlag() {
		// TODO Auto-generated method stub
		String sqlFlag = "?,?,?,?";
		return sqlFlag;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return tableName;
	}
	
	
	
}
