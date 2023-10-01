public class binarySearch{
    public int binarySearchIndex(int[] numbers,int target)
    {
        int res=-1;
        int l=0;
        int r=numbers.length-1;
        while(l<=r)
        {
            int mid=(l+r)/2;
            if(numbers[mid]==target)
            {
                res=mid;
                l=mid-1;
            }
            else if(numbers[mid]<target)
            {
                l=mid+1;
            }
            else
            {
                r=mid-1;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println("Hello world!");
    }
}