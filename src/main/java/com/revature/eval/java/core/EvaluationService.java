package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String[] sArr = phrase.split(" |-");
		String result = "";
		
		for(String s: sArr) {
			result = result.concat(s.substring(0, 1));
		}
		
		return result.toUpperCase();
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			if(getSideOne() == getSideTwo() && getSideOne() == getSideThree()) {
				return true;
			}
			
			return false;
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			if(getSideOne() == getSideTwo() || getSideOne() == getSideThree() || getSideTwo() == getSideThree()) {
				return true;
			}
			
			return false;
		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			if(getSideOne() != getSideTwo() && getSideOne() != getSideThree()) {
				return true;
			}
			
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		char[] onePointGroup = new char[]{'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'};
		char[] twoPointGroup = new char[]{'D', 'G'};
		char[] threePointGroup = new char[] {'B', 'C', 'M', 'P'};
		char[] fourPointGroup = new char[] {'F', 'H', 'V', 'W', 'Y'};
		char[] fivePointGroup = new char[] {'K'};
		char[] eightPointGroup = new char[] {'J', 'X'};
		char[] tenPointGroup = new char[] {'Q', 'Z'};
		int score = 0;
		string = string.toUpperCase();
		
		for(int i = 0; i < string.length(); i++) {
			char temp = string.charAt(i);
			for(int j = 0; j < onePointGroup.length; j++) {
				if(temp == onePointGroup[j])
				{
					score += 1;
				}
			}
			for(int j = 0; j < twoPointGroup.length; j++) {

				if(temp == twoPointGroup[j])
				{
					score += 2;
				}
			}
			for(int j = 0; j < threePointGroup.length; j++) {

				if(temp == threePointGroup[j])
				{
					score += 3;
				}
			}
			for(int j = 0; j < fourPointGroup.length; j++) {

				if(temp == fourPointGroup[j])
				{
					score += 4;
				}
			}
			for(int j = 0; j < fivePointGroup.length; j++) {

				if(temp == fivePointGroup[j])
				{
					score += 5;
				}
			}
			for(int j = 0; j < eightPointGroup.length; j++) {

				if(temp == eightPointGroup[j])
				{
					score += 8;
				}
			}
			for(int j = 0; j < tenPointGroup.length; j++) {

				if(temp == tenPointGroup[j])
				{
					score += 10;
				}
			}
		}
		
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) throws IllegalArgumentException {
		// TODO Write an implementation for this method declaration
		String regex = "[0-9]";
		String temp = "";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(string);
		int index = 0;
		
		while(m.find()) {
			temp = temp.concat(string.substring(m.start(), m.end()));
		}
		System.out.println(temp);
		if(temp.length() > 11) {
			throw new IllegalArgumentException("The string contains more than 11 digits");
		}
		else if(temp.length() < 10) {
			throw new IllegalArgumentException("The string contains non numeric values");
		}
		regex = "([2-9][0-9]{2}){2}[0-9]{4}";
		p = Pattern.compile(regex);
		m = p.matcher(temp);
		if(!m.find())
		{
			throw new IllegalArgumentException("The string does not follow this pattern: NXXNXXXXXX");
		}
		/*
		if(!temp.matches("[0-9]+")) {
			throw new IllegalArgumentException("The string contains non numeric values");
		}//*/
		
		return temp;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration
		int temp = 0;
		Map<String, Integer> map = new HashMap<>();
		
		String[] sArr = string.split(" |,\n|,");
		for(String sword: sArr) {
			if (map.containsKey(sword)) {
				temp = map.get(sword);
				map.put(sword, temp + 1);
			} else {
				map.put(sword, 1);
			}
		}

		return map;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int first = 0;
			int last = sortedList.size();
			int mid = 0;
			T t1 = null;
			int result = 0;
			
			while(first != last) {
				if(result < 0) {
					last = mid - 1;
				}
				else if(result > 0) {
					first = mid + 1;
				}
				mid = (((last - first)/2) + first);
				t1 = sortedList.get(mid);
				//less than mid if the result is less then 0
				result = (Integer.parseInt(t.toString()) - Integer.parseInt(t1.toString()));
				if(result == 0) {
					return mid;
				}
			}
//			System.out.println("Item is not in List.");
			
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		// TODO Write an implementation for this method declaration
		String[] sArr = string.toLowerCase().split(" ");
		char[] vowels = new char[] {'a', 'e', 'i', 'o', 'u'};
		String temp = "", first = "";
		boolean isVowel = false;
		string = "";
		
		for(String s: sArr) {
			temp = s;
			isVowel = false;
			while(!isVowel) {
				for(char vowel: vowels) {
					first = temp.substring(0, 1);
					if(first.equals(String.valueOf(vowel))) {
						isVowel = true;
						temp = temp.concat("ay");
						break;
					}
					else {
						temp = temp.substring(1);
						temp = temp.concat(first);
					}
				}
			}
			string = string.concat(temp);
			string = string.concat(" ");
		}
		
		return string.stripTrailing();
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		String value = String.valueOf(input);
		int power = value.length();
		int temp = 0;
		
		for(int i = 0; i < power; i++) {
//			System.out.println(value.substring(i, i + 1));
			temp += Math.pow(Integer.parseInt(value.substring(i, i + 1)), power);
//			System.out.println(temp);
		}
		
		if(temp == input) {
			return true;
		}
		
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> factors = new ArrayList<Long>();
		List<Long> primeFactors = new ArrayList<Long>();
		boolean prime;
		
		if(l == 2) {
			factors.add(2l);
			return factors;
		}

		//this simply finds the factors of the user's input l
		for (long i = 2; i < l; i++) {
			if (l % i == 0) {
				// System.out.println(i + " is a factor of " + l);
				// System.out.println(l / i + " is a factor of " + l);
				factors.add(l / i);
				factors.add(i);
			}
		}
		//this for loop is going through the list of factors to find the one that are prime numbersS
		for (long factor : factors) {
			prime = true;
			for (int i = 2; i < factor; i++) {
				if (factor % i == 0) {
					prime = false;
				}
			}
			if (prime) {
				primeFactors.add(factor);
				// System.out.println(factor + " is a prime factor.");
			}
		}
		
		//This section does a series of divisions to conclude which permutation of the prime factors 
		//multiply together to equal the user input l
		double temp = l;
		double d = 0.0;
		for (int i = 0; i < primeFactors.size(); i++) {
			factors.clear();
			factors.add(primeFactors.get(i));
			temp = l / primeFactors.get(i);
			for (int j = 0; j < primeFactors.size(); j++) {
				d = Math.round((temp / (double) primeFactors.get(j)));
				if (temp % primeFactors.get(j) == 0) {
					factors.add(primeFactors.get(j));
					temp = temp / primeFactors.get(j);
				}
				if (d == 1) {
					return factors;
				}
			}
		}

		return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			// TODO Write an implementation for this method declaration
			char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			String rotKey = "";
			int index = 0;
			
			for(int i = 0; i < string.length(); i++) {
				if(!Character.isLetter(string.charAt(i))) {
					rotKey = rotKey.concat(String.valueOf(string.charAt(i)));
				}
				for(int j = 0; j < 26; j++) {
					if(alphabet[j] == Character.toLowerCase(string.charAt(i))) {
//						System.out.println(string.charAt(i));
						index = j + key;
						if(index > 25) {
							index = index - 26;
						}
//						System.out.println(index);
						if(Character.isUpperCase(string.charAt(i))) {
							rotKey = rotKey.concat(String.valueOf(alphabet[index]).toUpperCase());
						}
						else {
							rotKey = rotKey.concat(String.valueOf(alphabet[index]));
						}
						
					}
				}
			}
			
			return rotKey;
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) throws IllegalArgumentException {
		// TODO Write an implementation for this method declaration
		boolean prime = true;
		int primeNum = 1;
		int nth = 1;
		
		if(i < 1) {
			throw new IllegalArgumentException("Can not obtain less than the first prime number");
		}
		
		while(nth <= i) {
			prime = true;
			primeNum++;
			for(int k = 2; k <= primeNum/2; k++) {
				if(primeNum % k == 0) {
					prime = false;
				}
			}
			if(prime) {
//				System.out.println(primeNum + " is a prime number.");
				nth++;
			}
			
		}
		
		return primeNum;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		
		private static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		private static char[] reversedAlphabet = "zyxwvutsrqponmlkjihgfedcba".toCharArray();
		
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			String encoded = "";
			boolean isAdded = false;
			int numAdded = 0;
			
			for(int i = 0; i < string.length(); i++) {
				if(Character.isDigit(string.charAt(i)))
				{
					encoded = encoded.concat(string.substring(i, i + 1));
					isAdded = true;
					numAdded++;
				}
				if(Character.isLetter(string.charAt(i))) {
					for(int j = 0; j < 26; j++) {
						if(alphabet[j] == Character.toLowerCase(string.charAt(i))) {
							encoded = encoded.concat(String.valueOf(reversedAlphabet[j]));
							isAdded = true;
							numAdded++;
						}
					}
				}
				if(numAdded % 5 == 0 && isAdded) {
//					System.out.println(numAdded);
					encoded = encoded.concat(" ");
					isAdded = false;
				}
			}
			
			return encoded.stripTrailing();
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String decoded = "";
			
			for(int i = 0; i < string.length(); i++) {
				if(Character.isLetter(string.charAt(i))) {
					for(int j = 0; j < 26; j++) {
						if(reversedAlphabet[j] == Character.toLowerCase(string.charAt(i))) {
							decoded = decoded.concat(String.valueOf(alphabet[j]));
						}
					}
				}
				if(Character.isDigit(string.charAt(i)))
				{
					decoded = decoded.concat(string.substring(i, i + 1));
				}
			}
			
			return decoded;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		// TODO Write an implementation for this method declaration
		List<Integer> num = new ArrayList<>();
		boolean valid = false;
		int sum = 0;
		
		for(int i = 0; i < string.length(); i++) {
			if(Character.isLetter(string.charAt(i))) {
				if(string.charAt(i) == 'X') {
					num.add(10);
				}
				else {
					return false;
				}
				
			}
			if(Character.isDigit(string.charAt(i))) {
				num.add(Integer.parseInt(string.substring(i, i + 1)));
			}
		}
		
		for(int i = 0; i < 10; i++) {
//			System.out.println((10 - i) + " " + num.get(i));
			if(!num.isEmpty()) {
				sum += ((10 - i) * num.get(i));
			}
		}
		if(sum % 11 == 0) {
			valid = true;
		}
		
		return valid;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		Boolean[] boolArray = new Boolean[26];
		boolean pangram = true;
		Arrays.fill(boolArray, false);
		
		for(int i = 0; i < string.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(alphabet[j] == string.charAt(i)) {
					boolArray[j] = true;
				}
			}
		}
		
		for(boolean bool: boolArray) {
			if(bool == false) {
				pangram = false;
			}
		}
		
		return pangram;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		LocalDateTime ldt = null;
		LocalDate ld = null;
		if(given.getClass() == LocalDateTime.class) {
			ldt = (LocalDateTime) given;
			ldt = ldt.plusHours(1);
			ldt = ldt.plusMinutes(46);
			ldt = ldt.plusSeconds(40);
		}
		else {
			ld = (LocalDate) given;
			ldt = ld.atTime(1, 46, 40);
		}
		ldt = ldt.plusYears(31);
		ldt = ldt.plusDays(251);
		
		return ldt;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		List<Integer> list = new ArrayList<>();
		int sum = 0;
		
		for(int j = 1; j < i; j++) {
			for(int k = 0; k < set.length; k++) {
				if(j % set[k] == 0) {
					if(!list.contains(j)) {
						list.add(j);
					}
				}
			}
		}
		
		for(Integer num: list) {
			sum += num;
		}
		
		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		String[] sArr = string.split(" ");
		int sum = 0, temp = 0;
		boolean doubleIt = false;
		
		string = "";
		for(String s: sArr) {
			string = string.concat(s);
		}
		//length validation
		if(string.length() <= 1) {
			return false;
		}
		//reverse the string for the purpose of doubling every 2nd digit starting from the RIGHT
		StringBuilder reversed = new StringBuilder(string);
		reversed.reverse();
		string = reversed.toString();
		System.out.println(string);
		
		//checking for non-numerical values and performing the algorithm
		for(int i = 0; i < string.length(); i++) {
			if(!Character.isDigit(string.charAt(i))) {
//				System.out.println("The string is invalid as it contains non-numerical values");
				return false;
			}
			else {
				temp = Integer.parseInt(string.substring(i, i + 1));
				if(doubleIt) {
					temp = (temp * 2);
					if(temp > 9) {
						temp -= 9;
					}
					doubleIt = false;
				}
				else {
					doubleIt = true;
				}
				sum += temp;
			}
		}
		
		//check if divisible by 10
		if(sum % 10 != 0) {
//			System.out.println("The string is invalid, its not divisible by 10");
			return false;
		}
		
		return true;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		String[] sArr = string.split(" ");
		String temp = "", arithmeticOperation = "";
		int[] set = new int[2];
		int index = 0, results = 0;
		
		for(String s: sArr) {
			if(s.matches("(-?[0-9]+ ?)|(-?[0-9]+.?)|(-?[0-9]+\\\\??)")) {
				temp = "";
				for(char c: s.toCharArray()) {
					if(Character.isDigit(c) || c == '-') {
						temp = temp.concat(String.valueOf(c));
					}
				}
				if(index < 2) {
					set[index] = Integer.parseInt(temp);
					index++;
				}
			}
			if(s.contains("plus") || s.contains("add")) {
//				System.out.println("we are adding");
				arithmeticOperation = "ADD";
			}
			else if(s.contains("minus") || s.contains("subtract")) {
//				System.out.println("we are subtracting");
				arithmeticOperation = "SUB";
			}
			else if(s.contains("multiply") || s.contains("multiplied")) {
//				System.out.println("we are multiplying");
				arithmeticOperation = "MUL";
			}
			else if(s.contains("divide") || s.contains("divided")) {
//				System.out.println("we are dividing");
				arithmeticOperation = "DIV";
			}
		}
		switch(arithmeticOperation) {
		case "ADD":
			results = (set[0] + set[1]);
			break;
		case "SUB":
			results = (set[0] - set[1]);
			break;
		case "MUL":
			results = (set[0] * set[1]);
			break;
		case "DIV":
			results = (set[0] / set[1]);
			break;
		}
		
		return results;
	}
}
