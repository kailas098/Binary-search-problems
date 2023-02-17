public class FirstAndLastIndex
{
	public static void main(String[] args)
	{

	}

	public static int[] firstLastIndex(int[] arr, int tar)
	{
		int[] res ={-1,-1};

		res[0] = findIndex(arr, tar, true);

		if(res[0]>0)
		{
			res[1]= findIndex(arr, tar, false);
		}

		return res;
	}

	public static int findIndex(int[] arr, int tar, boolean firstIndex)
	{
		int beg=0, len=arr.length-1,val=-1;

		while(beg<=len)
		{
			int mid = beg+(len-beg)/2;

			if(arr[mid]==tar)
			{
				val=mid;
				if(firstIndex)
				{
					len=mid-1;
				}
				else
				{
					beg=mid+1;
				}
			}

			else
			{
				if(arr[mid]>tar)
				{
					len=mid-1;
				}
				else
				{
					beg=mid+1;
				}
			}
		}

		return val;
	}
}
