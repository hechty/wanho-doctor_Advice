package factory;

import entry.DeptDao;

//���ڵ���daoȥ���ҵ���߼�
public class Service {
	
	DeptDao deptDao = SimpleFactory.getDeptDaoObject();
	
	public void test() {
		deptDao.add();
	}

}
