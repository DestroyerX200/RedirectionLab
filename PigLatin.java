import java.util.*;
public class PigLatin {
	public static String pigLatinSimple(String s) {
		String oldWord = s.toLowerCase();
		String newWord = "";
		String[] vowels = {"a", "e", "i", "o", "u"};
		String firstLetter = oldWord.substring(0, 1);
		boolean firstLetterIsVowel = false;
		for (String vowel : vowels) {
			if (firstLetter.equals(vowel)) {
				firstLetterIsVowel = true;
			}
		}
		if (firstLetterIsVowel) {
			newWord += oldWord + "hay";
		} else {
			newWord += oldWord.substring(1) + firstLetter + "ay";
		}
		return newWord;
	}
	public static void main ( String[] args ) {
		Scanner n = new Scanner( System.in );
		while (n.hasNextLine()) {
			Scanner line = new Scanner( n.nextLine() );
			while (line.hasNext()) {
				String word = line.next();
				System.out.print(pigLatinSimple(word));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}