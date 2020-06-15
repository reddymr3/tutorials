package io.lambdas;

public class ThisReferenceExample {

	public static void main(String[] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		// System.out.println(this); //This cannot be accessed in a static
		// method
		thisReferenceExample.doProcess(10, new Process() {
			@Override
			public void process(int i) {
				System.out.println("Value of i is : " + i);
				System.out.println(this);
			}

			@Override
			public String toString() {
				return "Anonymous inner class";
			}
		});

		thisReferenceExample.doProcess(10, i -> {
			System.out.println(i);
			//System.out.println(this); this will not be correct
		});
		
		thisReferenceExample.execute();
	}
	
	public String toString() {
		return "This is main object class";
	}

	public void doProcess(int i, Process p) {
		p.process(i);
	}
	
	public void execute(){
		// this===?
		doProcess(10, i -> {
			System.out.println(i);
			System.out.println(this);
		});
	}

}
