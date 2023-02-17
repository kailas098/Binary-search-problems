class CelingNumber 
{
    public static void main(String[]  args)
    {
        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(findCelingNumber(arr,0));
    }

    public static int findCelingNumber(int[] arr,int tar)
    {
        int beg=0,end=arr.length-1;

        if(tar>arr[end])
        {
            return -1;
        }

        while(beg<end)
        {
            int mid=beg+(end-beg)/2;

            if(tar==arr[mid])
            {
                return arr[mid];
            }

            else
            {
                if(arr[mid]<tar)
                {
                    beg=mid+1;
                }
                else
                {
                    end=mid-1;
                }
            }
        }

        return arr[beg];
    } 
}
