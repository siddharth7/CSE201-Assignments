package com.iiitd.ap.lab1;

public class InsertionSorting {
	static int swaps=0;
	public static <T extends Comparable<T>> T[] Sort(T[] arr)
	{
		swaps=0;
		int i,j;
		T val;
		for(i=1;i<arr.length;i++)
		{
			val=arr[i];
			j=i-1;
			while(j>=0 && arr[j].compareTo(val)>0){
				arr[j+1]=arr[j];
				j--;
				swaps++;
			}
			arr[j+1]=val;
		}
		return arr;
	}
	public static void main(String[] args)
	{
//		Integer[] list1 = {34, 17, 23, 35, 17, 45, 9, 1};
//        System.out.println("Original Array: ");
//        sortings(list1);
//        for(int i=0;i<list1.length;i++)
//            System.out.println(list1[i]);
//        System.out.println(counter);
	}

}
