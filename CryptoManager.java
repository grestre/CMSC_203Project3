

public class CryptoManager {
	
	private static final char LOWER_BOUND = 32;
	private static final char UPPER_BOUND = 95;
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		boolean bounds = true;
		for (int a = 0; a< plainText.length(); a++)
		{
			if(!(plainText.charAt(a) >= LOWER_BOUND && plainText.charAt(a) <= UPPER_BOUND))
			{
				bounds = false;
				break;
			}
		}
		return bounds;
	}
		    
	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		String encrypted = "";
		if(stringInBounds(plainText))
		{
			for (int a = 0; a<plainText.length(); a++)
			{
				char aChar = plainText.charAt(a);
				int encryptedChar1 = ((int)aChar+key);
				while (encryptedChar1 > UPPER_BOUND)
				{
					encryptedChar1-=RANGE;
				}
				encrypted += (char)encryptedChar1;
				
			}
		}
		return encrypted;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		String encrypted = "";
		int bellasoStrLength = bellasoStr.length();
		for (int a=0; a<plainText.length(); a++)
		{
			char aChar = plainText.charAt(a);
			int encryptedChar1 = ((int)aChar+(int)bellasoStr.charAt(a%bellasoStrLength));
			while (encryptedChar1 > (int)UPPER_BOUND)
			{
				encryptedChar1 -=RANGE;
			}
			encrypted+=(char)encryptedChar1;
		}
		return encrypted;
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		String decryptedCaesar = "";
		for(int a = 0; a<encryptedText.length(); a++)
		{
			char aChar = encryptedText.charAt(a);
			int decryptedChar1 = ((int)aChar-key);
			while(decryptedChar1 <LOWER_BOUND)
			{
				decryptedChar1+=RANGE;
			}
			decryptedCaesar+=(char)decryptedChar1;
		}
		return decryptedCaesar;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		String decryptedText = "";
		int bellasoStrLength = bellasoStr.length();
		for (int a = 0; a < encryptedText.length(); a++)
		{
			char aChar = encryptedText.charAt(a);
			int decryptedCharint = ((int)aChar-(int)bellasoStr.charAt(a%bellasoStrLength));
			while (decryptedCharint < (int)LOWER_BOUND) 
			{
				decryptedCharint += RANGE;
			}
			decryptedText+=(char)decryptedCharint;
		}
		return decryptedText;
	}
}
