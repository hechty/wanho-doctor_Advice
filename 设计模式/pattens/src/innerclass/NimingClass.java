package innerclass;

public abstract class NimingClass {

	public abstract void add();
	
	public static void main(String[] args) {
		new NimingClass() {

			@Override
			public void add() {
				// TODO Auto-generated method stub
				
				System.out.println("nnnnnnnnnn");
			}
			
		}.add();
	}
}
