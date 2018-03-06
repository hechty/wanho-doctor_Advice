package factory;

import entry.DeptDao;

//用于调用dao去完成业务逻辑
public class Service {
	
	DeptDao deptDao = SimpleFactory.getDeptDaoObject();
	
	public void test() {
		deptDao.add();
	}

}
