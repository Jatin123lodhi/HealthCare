package utils;

import java.util.Random;

public class RandomNo {
	public static int generateOtp() {
		Random r = new Random();
		int max = 9999;
		int min = 1111;
		
		int n = r.nextInt(max-min)+min;
		return n;
	}
	public static String generatePassword() {
		Random r = new Random();
		int max = 999999;
		int min = 111111;
		
		int n = r.nextInt(max-min)+min;
		
		return n+"";
	}
}
