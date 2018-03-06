package com.doctorAdvice.service;

import com.doctorAdvice.dao.Dao;
import com.doctorAdvice.entry.rowmapper.Advice;
import com.doctorAdvice.entry.user.Doctor;

public class DoctorService {
	Doctor doctor;
	public int createAdvice(Advice advice) {
		return Dao.baseAdd(advice);		
	}
}
