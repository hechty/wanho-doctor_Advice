package single;

public class Singleton {
	//����ģʽ
	private static final Singleton s = new Singleton();
	int i = 1;
	private Singleton() {
		
	}
	
	public static Singleton getSingleton() {
		return s;
	}
	
}
