package innerclass;

public class Test {
	public static void main(String[] args) {
		Outer o = new Outer();
		o.outTest();
		o.outTest1();
		System.out.println("------------");
		Outer.Inner inner = new Outer().new Inner();
		inner.innerTest();
		Outer.InnerStatic inner2= Outer.new InnerStatic();
		
	}

}
