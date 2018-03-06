package agancy;

public class Proxy 
	implements DoSomething{

	private DoSomething dos;
	
	public Proxy(DoSomething dos) {
		super();
		this.dos = dos;
	}

	@Override
	public void add() {
		// TODO Auto-generated method stub
		System.out.println("check if ฝปังทั");
		dos.add();
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("check other");
		dos.delete();
		
	}
	
}
