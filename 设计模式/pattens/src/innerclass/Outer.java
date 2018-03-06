package innerclass;

public class Outer {

	private int outerI = 1;
	private static String test = "ceshi";
	
	public Outer() {}
	public void outTest() {
		System.out.println(outerI);
		Inner i = new Inner();
		i.innerI = 10;
		i.innerTest();
		
	}
	
	public void outTest1() {
		int x = 1;
		test = "aaaa";
	}
	
	public static void outTest2(){
		int x = 2;
		test = "aaaa";
	}
	
	public class Inner {
		int innerI = 1;
		void innerTest() {
			System.out.println(outerI);
			System.out.println("This is innerClass");
		}
	}
	
	public static class InnerStatic {
		int innerSI = 1;
		void innerTest() {
			System.out.println("This is static inner class");
			System.out.println(test);
		}
	}
	
}
