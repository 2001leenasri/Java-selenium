package printName;

public class PrimeNumber {
     public static void main(String[] args) {
		int num=5;
		boolean isprime=true;
		
		if(num<=1) {
			isprime=false;
		}
		else {
			for(int i=2;i<=num/2;i++) {
				if(num%i==0) {
					isprime=false;
					break;
				}
			}
		}
		if(isprime) {
			System.out.println("It is a prime number");
		}
		else {
			System.out.println("It is not a prime number");
		}
     }
}
