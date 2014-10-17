import java.util.ArrayList;
import java.util.List;

public class ConsecutiveRemovalByInteger {

	public static void main(String[] args) {
		ConsecutiveRemovalByInteger d = new ConsecutiveRemovalByInteger();
		d.consecutiveRemoval("aaaaabbbaaccca", 2);
	}

	private void consecutiveRemoval(String targetString, Integer number) {

		int counter = 1;

		char[] charArray = targetString.toCharArray();
		char presentChar = charArray[0];
		int numberOfSpaces = 0;

		for (int i = 1; i < targetString.length(); i++) {

			if (presentChar == charArray[i]) {

				counter = counter + 1;
				if (counter > number) {
					charArray[i] = ' ';
					numberOfSpaces = numberOfSpaces + 1;
				}
			} else {
				presentChar = charArray[i];
				counter = 1;
			}

		}

		String outputString = new String(charArray);
		String resultString = outputString.replace(" ", "");
		System.out.println(resultString);

	}
}