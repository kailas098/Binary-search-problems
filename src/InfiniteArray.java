public class InfiniteArray
{
	public static void main(String[] args)
	{

	}

	public static int findAns(int[] arr, int tar)
	{
		int start=0, end=1;

		while(arr[end]<=tar)
		{
			int temp=end+1;
			end=end+(end-start+1)*2;
			start = temp;
		}

		return binsearch(arr, tar, end);
	}
	public static int binsearch(int[] arr,int tar,int end)
	{
		int beg=0;

		while(beg<=end)
		{
			int mid = (beg+end)/2;
			if(arr[mid]==tar)
			{
				return mid;
			}

			else
			{
				if(arr[mid]>tar)
				{
					end = mid-1;
				}
				else
				{
					beg=mid+1;
				}
			}
		}

		return -1;
	}
}
