public class RBSduplicteEle
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{2,2,3,3,9,2,2,2,2};
		System.out.println(findpiviot(arr));
	}

	public static int findpiviot(int[] arr)
	{
		int beg=0,end=arr.length-1;

		while(beg<=end)
		{
			int mid = beg+(end-beg)/2;

			if(arr[beg]==arr[mid] && arr[mid] == arr[end])
			{
				if(arr[beg]>arr[beg+1])
				{
					return beg;
				}
				beg++;

				if(arr[end-1]>arr[end])
				{
					return end-1;
				}
				end--;
			}

			else if(arr[mid]>arr[mid+1])
			{
				return mid;
			}
			else if(arr[mid-1]>arr[mid])
			{
				return mid-1;
			}

			if(arr[beg]>arr[mid])
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
