package com.felix.jdbc.dao;

import java.sql.ResultSet;

public interface RowMapper<T> {
	T rowMapper(ResultSet rs);
}
