package com.doctorAdvice.entry.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.doctorAdvice.common.TableName;
import com.doctorAdvice.common.TableProperties;
import com.doctorAdvice.dao.RowMapper;

public class Drug 
	implements RowMapper<Drug>{
//	public static final String tableName = TableName.drug;
	
	//药品id
	private int id;
	//药品名称
	private String name;
	//药品产地
	private String loc;
	//药品规格
	private String spec;
	//药品备注
	private String comment;
	//药品库存
	private int inventy;
	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Drug(int id, String name, String loc, String spec, String comment, int inventy) {
		super();
		this.id = id;
		this.name = name;
		this.loc = loc;
		this.spec = spec;
		this.comment = comment;
		this.inventy = inventy;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLoc() {
		return loc;
	}
	public String getSpec() {
		return spec;
	}
	public String getComment() {
		return comment;
	}
	public int getInventy() {
		return inventy;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setInventy(int inventy) {
		this.inventy = inventy;
	}
	@Override
	public Drug rowMapper(ResultSet rs) {
		// TODO Auto-generated method stub
		
		int nid;
		String nname;
		String nloc;
		String nspec;
		String ncomment;
		int ninventy;
		try {
			nid = rs.getInt(1);
			nname = rs.getString(2);
			nloc = rs.getString(3);
			nspec = rs.getString(4);
			ncomment = rs.getString(5);
			ninventy = rs.getInt(6);
			return new Drug(nid, nname, nloc, nspec, ncomment, ninventy);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
		
		
	}
	@Override
	public Object[] getProperty() {
		// TODO Auto-generated method stub
		Object[] obj = {id, name, loc, spec, comment, inventy};
		
		return obj;
	}
	@Override
	public String getSqlFlag() {
		// TODO Auto-generated method stub
		
		String sqlFlag = "?,?,?,?,?,?";
		return sqlFlag;
	}
	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return TableProperties.tableStruct.getProperty("drug");
	}
	
	
	
}
