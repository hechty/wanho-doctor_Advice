package com.doctorAdvice.dao;

import java.sql.ResultSet;

public interface RowMapper<T> {
	T rowMapper(ResultSet rs);
}
