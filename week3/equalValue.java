import java.util.*;

public class equalValue {
    public static List<Integer> find(int[] arr1,int[] arr2,int n){
        List<Integer> res=new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                // arr1[i] và arr2[j] giống nhau, thêm giá trị này vào kết quả và tăng cả hai chỉ số
                res.add(arr1[i]);
                i++;
                j++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr1 = {2,5,8,10,15};
        int[] arr2 = {5,8,9,12,15};
        List<Integer>res=find(arr1,arr2,5);
        for(int a : res)
        {
            System.out.println(a);
        }
    }
}
