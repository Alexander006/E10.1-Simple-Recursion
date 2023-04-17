import java.util.Arrays;

public class Recursion {

	public static int factorial(int n) {
		if(n == 0)
			return 1;

		return n * factorial(n - 1);
	}

	public static boolean isEven(int n) {

		if (n == 0)
			return true;

		if(n == 1)
			return false;

		return isEven(n - 2);
	}

	public static int sum(int[] numbers) {
		return sum(numbers, 0);
	}

	private static int sum(int[] numbers, int index) {
		if(index > numbers.length-1)
			return 0;

		int value = numbers[index];
		return value + sum(numbers,index + 1);
	}

	public static int max(int[] numbers) {
		return max(numbers, 0);
	}

	private static int max(int[] numbers, int index) {
		if(index > numbers.length - 1)
			return 0;

		int maxValue = max(numbers,index + 1);

		return Math.max(numbers[index],maxValue);
	}

	public static boolean isPalindrome(String phrase) {
		phrase.replaceAll(" ","");
		if(phrase.length() == 0 || phrase.length() == 1)
			return true;

		if(phrase.charAt(0) != phrase.charAt(phrase.length() - 1)) return false;
		char[] letters = phrase.toCharArray();
		String shorter = phrase.substring(1,phrase.length() -1);

		return isPalindrome(shorter);
	}

	/**
	 * Slices the given array recursively from the specified
	 * start index (inclusive) to the specified end index (exclusive).
	 * The resulting sliced array includes all elements from the start
	 * index up to, but not including, the end index.
	 *
	 * @param <T> the type of elements in the array
	 * @param elements the array to slice
	 * @param start the start index (inclusive) of the slice
	 * @param end the end index (exclusive) of the slice
	 * @return a new array containing the sliced elements
	 */
	public static <T> T[] slice(T[] elements, int start, int end) {
		/*
		 * 1. Base case: Return a single-element array.
		 *    Hint: Use Arrays.copyOfRange() to handle the generics
		 *          instead of trying to create a new generic array.
		 * 2. Recursively slice the left half of the array.
		 * 3. Recursively slice the right half of the array.
		 * 4. Concatenate the left and right arrays and return the result.
		 */


		if(end - start == 1){
			return Arrays.copyOfRange(elements,start,start+1);
		}

		int mid = (start + end) /2;

		T[] left = slice(elements,start,mid);
		T[] right = slice(elements,mid,end);

		return concatenateArrays(left, right);
	}

	/**
	 * Concatenates two arrays of the same type into a new array.
	 * The resulting concatenated array contains all elements from
	 * the first array followed by all elements from the second array.
	 *
	 * @param <T> the type of elements in the arrays
	 * @param a the first array to concatenate
	 * @param b the second array to concatenate
	 * @return a new array containing the concatenated elements
	 */
	private static <T> T[] concatenateArrays(T[] a, T[] b) {
		T[] result = Arrays.copyOf(a, a.length + b.length);

		System.arraycopy(b, 0, result, a.length, b.length);

		return result;
	}

}
