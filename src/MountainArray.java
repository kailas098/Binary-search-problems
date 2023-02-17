public class MountainArray {
    public static void main(String[] args)
    {
        int[] arr2 = {5,7,10,10,12,20,25,27,40,55,60,87,100,200,93,42,21,10};
        System.out.println(findInMountainArray(arr2, 7));
    }
    //mountain peak=========================================================

        /*slight variation from binary search..mountain array=[1,2,3,4,3,2,1](incraesing -> peak-> decreasing).
         * we are basically narrowing our potential answers within the array until 'start' and 'end' points  to 
         * the same element. 
         * in short we are searching for the largest element in the array, so we reduce the search range in
         * direction of increasing elements.
        */

        public static int mountainPeak(int[] arr)
        {
            int beg=0,end=arr.length;
    
            while(beg<end)
            {
                int mid=beg+(end-beg)/2;
    
                if(arr[mid]<arr[mid+1])
                {
                    beg=mid+1;
                }
                else
                {
                    end = mid;
                }
            }
    
            return end;
        }
    
        //find in mountain array================================================
        public static int findInMountainArray(int[] arr, int tar)
        {
            int peak = mountainPeak(arr);
            int search_left = orderAgnosticBsearch(arr, tar, 0, peak+1);
            if(search_left != -1)
            {
                return search_left;
            }
            return orderAgnosticBsearch(arr, tar, peak, arr.length-1);
        }
    
        public static int orderAgnosticBsearch(int[] arr, int tar, int beg, int end)
        {
            boolean isAsc = arr[beg]<arr[end];
    
            while(beg<=end)
            {
                int mid = beg+(end-beg)/2;
    
                if(arr[mid]==tar)
                {
                    return mid;
                }
    
                if(isAsc)
                {
                    if(tar<arr[mid])
                    {
                        end = mid-1;
                    }
                    else
                    {
                        beg = mid+1;
                    }
                }
    
                else
                {
                    if(tar<arr[mid])
                    {
                        beg = mid+1;
                    }
                    else
                    {
                        end = mid-1;
                    }
                }
            }
            return -1;
        }
    
        //find element in an infinite array=====================================
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
