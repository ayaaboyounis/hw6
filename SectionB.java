package il.ac.tau.cs.sw1.hw6;

import java.util.Arrays;

public class SectionB {
	
	/*
	* @post $ret == true iff exists i such that array[i] == value
	*/
	public static boolean contains(int[] array, int value)
	{ 
		if(array.length==0)
			return false;
		for(int i=0;i<array.length;i++)
			if(array[i]==value)
				return true;
		//TODO
		return false;
	}
	
	// there is intentionally no @post condition here 
	/*
	* @pre array != null
	* @pre array.length > 2
	* @pre Arrays.equals(array, Arrays.sort(array))
	*/
	public static int unknown(int[] array)
	{ 
		int[]sorted_arr=array;
		Arrays.sort(sorted_arr);
		if(array.length>2&&Arrays.equals(array,sorted_arr))
			return 1;
		return 0;
	}
	/*
	* @pre Arrays.equals(array, Arrays.sort(array))
	* @pre array.length >= 1
	* @post for all i array[i] <= $ret
	*/
	public static int max(int[] array)
	{ 
		//TODO
		return array[array.length-1];
	}
	
	/*
	* @pre array.length >=1
	* @post for all i array[i] >= $ret
	* @post Arrays.equals(array, prev(array))
	*/
	public static int min(int[] array)
	{ 
		//TODO
		return array[0];
	}
	
	/*
	* @pre word.length() >=1
	* @post for all i : $ret.charAt(i) == word.charAt(word.length() - i - 1)

	*/
	public static String reverse(String word) 
	{
		char [] char_word=word.toCharArray();
		char [] reversed_word=new char[char_word.length];
		for(int i=0;i<char_word.length;i++)
			reversed_word[i]=char_word[char_word.length-i-1];
		String Reversed=new String(char_word);
		return Reversed;
		
	}
	
	/*
	* @pre array != null
	* @pre array.length > 2
	* @pre Arrays.equals(array, Arrays.sort(array))
	* @pre exist i,j such that: array[i] != array[j]
	* @post !Arrays.equals($ret, Arrays.sort($ret))
	* @post for any x: contains(prev(array),x) == true iff contains($ret, x) == true
	*/
	public static int[] guess(int[] array) 
	{ 
		int[] new_arr=new int[array.length];
		int temp=array[array.length-1];
		array[array.length-1]=array[0];
		new_arr[0]=temp;
		
		return new_arr;
	}


}
