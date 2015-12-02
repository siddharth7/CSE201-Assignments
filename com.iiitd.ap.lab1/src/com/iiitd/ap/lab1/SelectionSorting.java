package com.iiitd.ap.lab1;

public class SelectionSorting<T> {
	public static int swaps=0;
	public static <T extends Comparable<T>> T[] Sort(T[] arr)
	{
		swaps=0;
		int i,j,mini = 0;
		for(i=0;i<arr.length-1;i++)
		{
			mini=i;
			for(j=i+1;j<arr.length;j++)
			{
				if(arr[mini].compareTo(arr[j])>0){
					mini=j;
				}
			}
		
			if(arr[mini].compareTo(arr[i])!=0)
				{
				T swap=arr[mini];
				arr[mini]=arr[i];
				arr[i]=swap;
				swaps++;
				}
		}
		return arr;
	}
	public static void main(String[] args)
	{
//		Integer[] list1 = {34, 17, 23, 35, 17, 45, 9, 1};
//        System.out.println("Original Array: ");
//        Sort(list1);
//        for(int i=0;i<list1.length;i++)
//            System.out.println(list1[i]);
//        System.out.println(swaps);
	}

}
