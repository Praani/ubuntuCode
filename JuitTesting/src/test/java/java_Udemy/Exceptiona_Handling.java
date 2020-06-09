package java_Udemy;

public class Exceptiona_Handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try {
		String str = null;
		str.length();		
	}	catch (NullPointerException e) {
		System.out.println("NullPointerException");
		e.printStackTrace();
	} 
	catch (Exception e) {
e.printStackTrace();
	}

	}

}
