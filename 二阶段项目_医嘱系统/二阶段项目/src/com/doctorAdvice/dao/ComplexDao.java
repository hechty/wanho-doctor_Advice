package com.doctorAdvice.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.doctorAdvice.dao.util.DbUtil;
import com.doctorAdvice.entry.rowmapper.AdviceDrug;
import com.doctorAdvice.entry.rowmapper.Drug;
import com.doctorAdvice.exception.UpdateAdviceDrugConcurrencyException;

/**
 * 复杂数据库操作,如分页,多表,事务等
 * @author Administrator
 *
 */
public class ComplexDao extends Dao{
	
	/**
	 * 增加一项用药详情,同时减少药品库存;返回最终变动的记录条数.
	 * @param adviceDrug
	 * @return 若返回0,表示添加失败;返回2表示添加成功.
	 */
	public static int addAdviceDrug(AdviceDrug adviceDrug) {
		int count = 3;
		conn = DbUtil.getConnection();
		//默认存在并发异常
		while(count == 3) {
			count = addAdviceDrugWithConnection(conn, adviceDrug);
		}
		DbUtil.close(null, null, conn);
		if(count != 2)
			count = 0;
		return count;
	}
	
	/**
	 * 批量增加医嘱用药.返回变动记录的条数.
	 * @param adviceDrugs
	 * @return 添加失败返回0;添加成功返回adviceDrugs.size()*2;
	 */
	public static int addAdviceDrugs(List<AdviceDrug> adviceDrugs) {
		int count = 0;
		int temp = 0;
		conn = DbUtil.getConnection();
		try {
			conn.setAutoCommit(false);
			for(AdviceDrug adviceDrug: adviceDrugs) {
				temp = addAdviceDrugWithoutCommit(conn, adviceDrug);
				if(temp != 2) {
					throw new SQLException("插入失败: " + adviceDrug.toString());
				}
				count += temp;
			}
			conn.setAutoCommit(true);
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			DbUtil.rollBack(conn);
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}finally {
			DbUtil.close(null, null, conn);
		}
		
		return count;
	}
	
	/**
	 * 增加一项用药详情,同时减少药品库存;返回(事务回滚前)变动的记录条数.若返回1,表示添加失败;返回2表示添加成功;
	 * 返回3表示添加失败,但是失败原因是另一线程中修改.应重新执行.
	 * 不关闭conn连接;
	 * @param conn
	 * @param adviceDrug
	 * @return 若返回0或1,表示添加失败;返回2表示添加成功;返回3表示添加失败,但是失败原因是另一线程中修改,应重新执行.
	 */
	protected static int addAdviceDrugWithConnection(Connection conn, AdviceDrug adviceDrug) {
		int count = 0;

		try {
			conn.setAutoCommit(false);
			count = addAdviceDrugWithoutCommit(conn, adviceDrug);
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DbUtil.rollBack(conn);
//			count = 0;
			e.printStackTrace();
		} 

		return count;
	}
	
	/**
	 * 增加用药详情,不关闭资源,不提交事务.
	 * @param conn
	 * @param adviceDrug
	 * @return
	 * @throws UpdateAdviceDrugConcurrencyException
	 */
	protected static int addAdviceDrugWithoutCommit(Connection conn, AdviceDrug adviceDrug) throws UpdateAdviceDrugConcurrencyException {
		int count = 0;
		count = baseAddWithConnection(adviceDrug, conn);
		if(count == 1) {
			Drug drug = queryByKey(new Drug(), "id", adviceDrug.getDrugId());
			//开启事务关联drug(仍有bug,若在此处线程休眠,另一线程修改drug,此操作将导致前一个线程的操作失败);
			count += baseUpdateWithConnection(conn, drug, "id", drug.getId());
			drug.setInventy(drug.getInventy() - adviceDrug.getDrugCount());
			count += baseUpdateWithConnection(conn, drug, "id", drug.getId());
		}
		//count = 3则上述过程修改了3条记录,并发修改.
		if(count == 3) {
			throw new UpdateAdviceDrugConcurrencyException("并发修改同一药品");
		}
		
		return count;
	}
	
	/**
	 * 
	 * 根据页数和每页的项数查询
	 * @param page
	 * @param entryPerPag
	 * @param rm
	 * @return
	 */
	public static <T> List<T> queryAllByPage(int page, int entryPerPag, RowMapper<T> rm){
		int lo = (page - 1) * entryPerPag + 1;
		int hi = page * entryPerPag;
		int max = getSum(rm);
		hi = hi > max ? max: hi;
		
		String sql = "SELECT  r.* FROM (SELECT ROWNUM ro, e.* FROM " + rm.getTableName() + " e) r WHERE ( r.ro >= ? AND r.ro <= ?)";
		//查询lo~hi的对象
		List<T> list = baseQuery(rm, sql, lo, hi);
		return list;
	}
}
