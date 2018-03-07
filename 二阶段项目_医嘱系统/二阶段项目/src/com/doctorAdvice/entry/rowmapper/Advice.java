package com.doctorAdvice.entry.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.List;

import com.doctorAdvice.common.TableName;
import com.doctorAdvice.dao.RowMapper;
//import com.doctorAdvice.entry.other.Patient;
import com.doctorAdvice.service.ChangeStatus;

public class Advice 
	implements RowMapper<Advice>, ChangeStatus{
	public static final String tableName = TableName.advice;
	private int adviceId;
	private String patientName;
	private String patientBed;
	private Date date;
	private String comment;
	private String status;
	private int doctorId;
//	private List<AdviceDrug> adviceDrugs;
	
	
	
	@Override
	public Advice rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		
		int newId = 0;
		String patientName = null;
		String patientBed = null;
		String newComment = null;
		String newStatus = null;
		int doctorId=0;
		Date newDate = null;
		try {
			newId = rs.getInt(1);
			patientName = rs.getString(2);
			patientBed = rs.getString(3);
			newComment = rs.getString(4);
			newStatus = rs.getString(5);
			doctorId = rs.getInt(6);
			newDate = rs.getDate(7);
			
			return new Advice(newId, patientName, patientBed
					, newComment, newStatus, doctorId, newDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
				
	}



	public Advice() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Advice(int adviceId, String patientName, String patientBed, String comment, String sataus, int doctorId, Date date) {
		super();
		this.adviceId = adviceId;
		this.patientName = patientName;
		this.patientBed = patientBed;
		this.date = date;
		this.comment = comment;
		this.status = sataus;
		this.doctorId = doctorId;
	}



	public int getAdviceId() {
		return adviceId;
	}



	public void setAdviceId(int adviceId) {
		this.adviceId = adviceId;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public String getPatientBed() {
		return patientBed;
	}



	public void setPatientBed(String patientBed) {
		this.patientBed = patientBed;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}



	public String getSataus() {
		return status;
	}


	@Override
	public void setStatus(String sataus) {
		this.status = sataus;
	}



	public int getDoctorId() {
		return doctorId;
	}



	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}



	@Override
	public Object[] getProperty() {
		// TODO Auto-generated method stub
		Object[] obj = {adviceId, patientName, patientBed, date, comment, 
							status, doctorId};
		
		return obj;
	}



	@Override
	public String getSqlFlag() {
		// TODO Auto-generated method stub
		String sqlFlag = "?,?,?,?,?,?,?";
		return sqlFlag;

	}



	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return tableName;
	}


}
