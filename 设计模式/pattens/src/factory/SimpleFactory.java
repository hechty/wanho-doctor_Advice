package factory;
/**
 * ������:���ĳ���ӿ�,�ṩ��Ӧ�Ķ���
 * ���Ʒ�ת:�����������Ȩ��,�ӵ������� �������,��ר�ŵĹ�������ж���Ĵ���
 * @author Administrator
 *
 */
import entry.*;
public class SimpleFactory {
	//ͨ��һ������,ר������ʵ����Ķ���
	public static DeptDao getDeptDaoObject() {
		return new DeptImp2();
	}

}
