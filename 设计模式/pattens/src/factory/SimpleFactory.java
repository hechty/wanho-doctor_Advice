package factory;
/**
 * 工厂类:针对某个接口,提供相应的对象
 * 控制反转:将创建对象的权限,从调用者中 分离出来,由专门的工厂类进行对象的创建
 * @author Administrator
 *
 */
import entry.*;
public class SimpleFactory {
	//通过一个方法,专门生产实现类的对象
	public static DeptDao getDeptDaoObject() {
		return new DeptImp2();
	}

}
