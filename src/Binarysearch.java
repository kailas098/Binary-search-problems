
public class Binarysearch 
{
    public static void main(String[] args) 
    {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(binarySearch(arr, 3)); 
    }

    static int binarySearch(int[] arr, int tar)
    {
        int beg=0, end=arr.length-1;
        
        while(beg<=end)
        {
            int mid=beg+(end-beg)/2;

            if(tar==arr[mid])
            {
                return mid;
            }

            else if(tar<arr[mid])
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
