package single;
/**
 * ����ģʽ,����ʽ
 * @author Administrator
 *
 */
public class Singleton2 {
	private static Singleton2 s;
	int i = 1;
	private Singleton2() {}
	public static synchronized Singleton2 getSingleton2() {
		if(s == null)
			s = new Singleton2();
		return s;
	}

}
