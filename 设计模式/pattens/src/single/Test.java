package single;

public class Test {
	public static void main(String[] args) {
		Singleton2 s = Singleton2.getSingleton2();
		s.i <<= 2;
		Singleton2 s2 = Singleton2.getSingleton2();
		System.out.println(s2.i);
	}

}
