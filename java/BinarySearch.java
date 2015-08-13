/**
 * @param array: the sorted integer array
 * @param key: the target to find
 * @return: The first position of the key, position starts from 0
 *			If no key in this array, return -1
*/

public class BinarySearch {
	public static int binarySearch(int[] array, int key) {
		if(array == null || array.length == 0) {
			return -1;
		}

		int start = 0, end = array.length - 1;
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(array[mid] == key) {
				end = mid; //for first occurance; if for last occurance, start = mid
			} else if(array[mid] > key) {
				end = mid;
			} else {
				start = mid;
			}
		}

		//for first occurance, put if(array[start]) before if(array[end])
		if(array[start] == key) {
			return start;
		} 
		if(array[end] == key) {
			return end;
		}
		return -1;
	
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 2};
		System.out.println(binarySearch(a, 2));
	}	
}
