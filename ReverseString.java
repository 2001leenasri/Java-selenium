package printName;

public class ReverseString {
   public static void main(String[] args) {
	   String input="Leenasri";
	// to split into a character
	   
	   char[] charArray= input.toCharArray();
	// to iterate the characters
			   for (int i = charArray.length - 1; i >= 0; i--) {
				   
				// to print the character
               System.out.print(charArray[i]);
}
}
}