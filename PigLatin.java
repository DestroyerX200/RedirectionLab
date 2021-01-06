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
			newWord = oldWord + "hay";
		} else {
			newWord = oldWord.substring(1) + firstLetter + "ay";
		}
		return newWord;
	}
	public static String pigLatin(String s) {
		if (s.length() == 1) {
			return pigLatinSimple(s);
		}
		String oldWord = s.toLowerCase();
		String newWord = "";
		String[] vowels = {"a", "e", "i", "o", "u"};
		String[] digraphs = {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};
		String firstTwoLetters = oldWord.substring(0, 2);
		boolean firstLetterIsVowel = false;
		boolean firstTwoLettersIsDigraph = false;
		for (String vowel: vowels) {
			if (firstTwoLetters.substring(0, 1).equals(vowel)) {
				firstLetterIsVowel = true;
			}
		}
		for (String digraph: digraphs) {
			if (firstTwoLetters.equals(digraph)) {
				firstTwoLettersIsDigraph = true;
			}
		}

		if (firstLetterIsVowel) {
			newWord = oldWord + "hay";
		}
		else if (firstTwoLettersIsDigraph) {
			newWord = oldWord.substring(2) + firstTwoLetters + "ay";
		}
		else {
			newWord = oldWord.substring(1) + oldWord.substring(0, 1) + "ay";
		}

		return newWord;
	}
	public static String pigLatinBest(String s) {
		String newWord = "";
		String alphabetAndNumbers = "abcdefghijklmnopqrstuvwxyz0123456789";
		boolean hasPunctuation = true;
		char lastCharacter = s.charAt(s.length()-1);
		for (int i = 0; i < alphabetAndNumbers.length(); i++) {
			if (lastCharacter == alphabetAndNumbers.charAt(i) ) {
				hasPunctuation = false;
			}
		}

		if (hasPunctuation) {
			newWord = pigLatin(s.substring(0, s.length()-1)) + lastCharacter;
		} else {
			newWord = pigLatin(s);
		}
		return newWord;
	}
	public static void main ( String[] args ) {
		// Scanner n = new Scanner( System.in );
		// while (n.hasNextLine()) {
		// 	Scanner line = new Scanner( n.nextLine() );
		// 	while (line.hasNext()) {
		// 		String word = line.next();
		// 		System.out.print(pigLatinSimple(word));
		// 		System.out.print(" ");
		// 	}
		// 	System.out.println();
		// }
		// Scanner n = new Scanner( System.in );
		// while (n.hasNextLine()) {
		// 	Scanner line = new Scanner( n.nextLine() );
		// 	while (line.hasNext()) {
		// 		String word = line.next();
		// 		System.out.print(pigLatin(word));
		// 		System.out.print(" ");
		// 	}
		// 	System.out.println();
		// }
		Scanner n = new Scanner( System.in );
		while (n.hasNextLine()) {
			Scanner line = new Scanner( n.nextLine() );
			while (line.hasNext()) {
				String word = line.next();
				System.out.print(pigLatinBest(word));
				System.out.print(" ");
			}
			if (n.hasNextLine()) {
				System.out.println();
			}
		}
	}
}