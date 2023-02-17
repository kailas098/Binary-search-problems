public class LargestSum
{
	public static void main(String[] args)
	{
		int[] arr = new int[]{7,2,5,8,10};
		System.out.println(findLargestSum(arr, 2));
	}

	public static int findLargestSum(int[] arr,int k)
	{
		//step-1) find the upper limit and lower limit of potential answers.

		int lower_Limit=0, upper_limit=0;

		for(int a:arr)
		{
			if (a>lower_Limit)
			{
				lower_Limit=a;
			}
			upper_limit+=a;
		}

		// step-2) Using binary search to find the sum of array elements with given number of division.
		while(lower_Limit<upper_limit)
		{
			int mid = lower_Limit+(upper_limit-lower_Limit)/2;

			//sum->sum of elements, count->no. of sub arrays formed.
			// count=1 because we'll always start with one sub array.

			int sum=0, count=1;

			for(int i=0;i<arr.length;i++)
			{
				//if sum of elements is less than mid then add it to sum...
				if(sum+arr[i]<=mid)
				{
					sum+=arr[i];
				}
				else
				{
					//when the sum exceeds mid new sum will be next element, abd count will be increased since we got another sub-array...
					sum=arr[i];
					count++;
				}
			}

			//if the there are more than specified no. of sub array search range will be mid-upper_limit.
			if(count>k)
			{
				lower_Limit=mid+1;
			}

			//lower limit - mid otherwise.
			else
			{
				upper_limit=mid;
			}
		}

		// In the end lower_limit = upper_limit .
		return lower_Limit;
	}
}
