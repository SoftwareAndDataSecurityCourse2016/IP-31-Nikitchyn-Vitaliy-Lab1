
public class Main {

	public static void main(String[] args) {		
		/*	
		String task1 = FileWorker.loadTask("task/task1.txt");
		System.out.println(task1);
		Decryptor decryptor = new SimpleDecryptor(task1);		
		System.out.println(decryptor.decrypt());
		decryptor.printKey();
		*/
				
		String task2 = FileWorker.loadTask("task/task2.txt");
		System.out.println(task2);
		Decryptor decryptor = new ViginerDecryptor(task2);
		System.out.println(decryptor.decrypt());
		decryptor.printKey();
	}	
	
	
	public static int gcd(int a, int b) {
	    if (b == 0) return a;
	    int x = a % b;
	    return gcd(b, x);
	}		
}
