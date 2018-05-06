package Morpion;

import java.util.Scanner;

public class Input {
	public static int readInt(Scanner scan) {
		int result = -1;
		String input = scan.nextLine();
		try {
			result = Integer.parseInt(input);
		} catch (NumberFormatException e) {

		}
		return result;

	}
}