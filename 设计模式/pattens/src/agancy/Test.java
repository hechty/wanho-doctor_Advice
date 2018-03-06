package agancy;

public class Test {
	public static void main(String[] args) {
		DoSomething dos = new DoStudent();
		Proxy pro = new Proxy(dos);
		pro.add();
		pro.delete();
	}

}
