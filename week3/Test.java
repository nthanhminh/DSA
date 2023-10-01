import java.util.*;

public class Test{
    public static void test(List<Integer>arr)
    {
        arr.add(1);
        arr.add(2);
    }
    public static void main(String[] args)
    {
        List<Integer>arr=new ArrayList<Integer>();
        arr.add(3);
        arr.add(4);
        test(arr);
        for(int c:arr)
        {
            System.out.println(c);
        }
    }
}