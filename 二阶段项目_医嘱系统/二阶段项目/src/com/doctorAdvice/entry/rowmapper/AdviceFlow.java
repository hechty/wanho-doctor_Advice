package com.doctorAdvice.entry.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.doctorAdvice.dao.RowMapper;
import com.doctorAdvice.service.TableProperties;

public class AdviceFlow 
	implements RowMapper<AdviceFlow>{
//	private static final String
	private int id;
	private int adviceId;
	private String comment;
	private int actorId;
	private String status;
	private Date changeDate;
	public AdviceFlow(int id, int adviceId, String comment, int actorId, String status, Date changeDate) {
		super();
		this.id = id;
		this.adviceId = adviceId;
		this.comment = comment;
		this.actorId = actorId;
		this.status = status;
		this.changeDate = changeDate;
	}
	public AdviceFlow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAdviceId() {
		return adviceId;
	}
	public void setAdviceId(int adviceId) {
		this.adviceId = adviceId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return TableProperties.tableStruct.getProperty("adviceFlow");
	}
	@Override
	public String getSqlFlag() {
		// TODO Auto-generated method stub
		String sqlFlag = "?,?,?,?,?,?";
		return sqlFlag;
	}
	@Override
	public Object[] getProperty() {
		// TODO Auto-generated method stub
		Object[] obj = {id, adviceId, comment, actorId, status, changeDate};
		return obj;
	}
	@Override
	public AdviceFlow rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		int nid;
		int nadviceId;
		String ncomment;
		int nactorId;
		String status;
		Date changeDate;
		try {
			nid = rs.getInt(1);
			nadviceId = rs.getInt(2);
			ncomment = rs.getString(3);
			nactorId = rs.getInt(4);
			status = rs.getString(5);
			changeDate = rs.getDate(6);
			return new AdviceFlow(nid, nadviceId, ncomment, nactorId, status, changeDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
}
