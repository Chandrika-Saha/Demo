/**

-----Sample I/O-----
Enter Plaintext: The quick brown fox jumps over the lazy dog.
Enter Shift Value (Type 0 to EXIT): 2

Encrypted text: Vjg swkem dtqyp hqz lworu qxgt vjg ncba fqi.
Decrypted text: The quick brown fox jumps over the lazy dog.

**/

import java.util.Scanner;
//A Java Program to illustrate Caesar Cipher Technique
class Caesar{
	// Encrypts text using a shift od s
	public static void main(String[] args){
	    Scanner inputI = new Scanner(System.in);
	    Scanner inputS = new Scanner(System.in);
	    StringBuffer plainText = new StringBuffer();
	    int shift;

	    while(true){
	        System.out.print("Enter Plaintext: ");
	        plainText.append(inputS.nextLine());

	        System.out.print("Enter Shift Value (Type 0 to EXIT): ");
	        shift = inputI.nextInt();
	        if(shift == 0)
	            break;

	        if(shift > 26 || shift < 0){
	            shift = shift % 26;
	        }

	        if(shift < 0)
	            shift = shift + 26;

	        System.out.println();
	        StringBuffer encryptedText = encrypt(plainText,shift);
	        System.out.println("Encrypted text: " + encryptedText);
	        System.out.println("Decrypted text: " + decrypt(encryptedText, shift));
			System.out.println();

			plainText = new StringBuffer();
	    }
	}

	public static StringBuffer encrypt(StringBuffer text, int s) {
		StringBuffer result= new StringBuffer();
		char ch;

		for (int i=0; i<text.length(); i++) {
			if (Character.isUpperCase(text.charAt(i)))
				ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
			else if(Character.isLowerCase(text.charAt(i)))
				ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
			else
				ch = (char)((int)text.charAt(i));
			result.append(ch);
		}

		return result;
	}

	 public static StringBuffer decrypt(StringBuffer text, int s) {
            StringBuffer result= new StringBuffer();
            char ch;
            int offset;

            for (int i=0; i<text.length(); i++) {
		if (Character.isUpperCase(text.charAt(i))){
	            offset = (int)text.charAt(i) - s - 65;
	            if(offset >= 0){
	                ch = (char) (offset % 26 + 65);
	            }
                    else{
	                ch = (char) ((26 + offset) % 26 + 65);
	            }
		}
		else if(Character.isLowerCase(text.charAt(i))){
	            offset = (int)text.charAt(i) - s - 97;
	            if(offset >= 0){
	                ch = (char) (offset % 26 + 97);
	            }else{
	                ch = (char) ((26 + offset) % 26 + 97);
	            }
		}
		else
                    ch = (char)((int)text.charAt(i));

                result.append(ch);
            }

            return result;
	}
}
