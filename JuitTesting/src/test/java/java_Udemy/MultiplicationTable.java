package java_Udemy;

public class MultiplicationTable {

	public static void main(String[] args) {
		int a = 5;
		int result;
		for (int i=1; i<=10; i++) {
			result=a*i;
			System.out.println(i +" * " +a +" = " + result);
		}
		System.out.println("Numbers of minutes is a day = "+ (60*24));
		System.out.println("Numbers of seconds is a day = "+ (60*60*24));
	}
}
