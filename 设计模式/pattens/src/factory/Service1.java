package factory;

import entry.DeptDao;

//���ڵ���daoȥ���ҵ���߼�
public class Service1 {
	
	DeptDao deptDao = SimpleFactory.getDeptDaoObject();
	
	public void test() {
		deptDao.add();
	}

}
