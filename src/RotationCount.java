public class RotationCount
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{27,32,36,40,52,61,79,81,10};
		System.out.println(findpiviot(arr));
	}

	public static int findpiviot(int[] arr)
	{
		int beg=0, end=arr.length-1;

		while(beg<=end)
		{
			int mid = beg+(end-beg)/2;

			if(arr[mid]>arr[mid+1])
			{
				return mid+1;
			}

			else if(arr[mid-1]>arr[mid])
			{
				return mid;
			}

			else if(arr[beg]>arr[mid])
			{
				end = mid-1;
			}

			else
			{
				beg = mid+1;
			}
		}
		return -1;
	}
}
