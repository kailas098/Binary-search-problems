public class RotatedBinarySearch
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{27,32,36,40,40,40,40,40,52,61,79,81,81,10};
		System.out.println(searchInRotatedArr(arr,40));
	}

	public static int searchInRotatedArr(int[] arr, int tar)
	{
		int piviot=finPiviot(arr);
		if(piviot == -1)
		{
			return binarySearch(arr, tar,0, arr.length-1);
		}
		else
		{
			if(tar>arr[0])
			{
				return binarySearch(arr,tar,0,piviot);
			}
			else
			{
				return binarySearch(arr,tar,piviot,arr.length-1);
			}
		}
	}

	public static int finPiviot(int[] arr)
	{
		int beg = 0, end = arr.length-1;

		while (beg < end)
		{
			int mid = beg+(end-beg)/2;

			if(mid<end && arr[mid]>arr[mid+1])
			{
				return mid;
			}

			else if(mid>beg && arr[mid-1]>arr[mid])
			{
				return mid-1;
			}

			else if(arr[beg]>arr[mid])
			{
				end=mid-1;
			}
			else
			{
				beg=mid+1;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] arr, int tar,int beg ,int end)
	{
		while(beg<=end)
		{
			int mid=beg+(end-beg)/2;

			if(tar==arr[mid])
			{
				return mid;
			}
			else if(tar<arr[mid])
			{
				end=mid-1;
			}
			else
			{
				beg=mid+1;
			}
		}
		return -1;
	}
}
