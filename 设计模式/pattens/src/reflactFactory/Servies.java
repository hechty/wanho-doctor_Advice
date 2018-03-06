package reflactFactory;
import entry.*;
public class Servies {
	DeptDao dept = (DeptDao)Factory.createObject("dept"); 
	
	public void test() {
		dept.add();
	}

}
