package com.doctorAdvice.entry.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.doctorAdvice.common.TableName;
import com.doctorAdvice.dao.RowMapper;

public class AdviceDrug 
	implements RowMapper<AdviceDrug>{
	public static final String tableName = TableName.adviceDrug;
	private int adId;
	private int drugId;
	private int drugCount;
	private int adviceId;
	public AdviceDrug() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdviceDrug(int adId, int drugInventy, int drugCount, int adviceId) {
		super();
		this.adId = adId;
		this.drugId = drugInventy;
		this.drugCount = drugCount;
		this.adviceId = adviceId;
	}
	public int getAdId() {
		return adId;
	}
	public void setAdId(int adId) {
		this.adId = adId;
	}
	public int getDrugId() {
		return drugId;
	}
	public void setDrugId(int drugInventy) {
		this.drugId = drugInventy;
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
		Object[] obj = {adId, drugId, drugCount, adviceId};
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
