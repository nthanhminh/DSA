import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }
    
    public void getCgpa(double cgpa)
    {
        this.cgpa = cgpa;
    }
}


public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        List<Student> a = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i=0;i<n;i++)
        {
            int id = scanner.nextInt();
            String name = scanner.next();
            double cgpa = scanner.nextDouble();
            Student s = new Student(id,name,cgpa);
            a.add(s);
        }
        Collections.sort(a,(Student s1, Student s2) -> {
            if (s1.getCgpa() != s2.getCgpa()) 
            {
                return Double.compare(s2.getCgpa(), s1.getCgpa());
            } 
            else if (!s1.getName().equals(s2.getName())) 
            {
                return s1.getName().compareTo(s2.getName());
            } 
            else 
            {
                return Integer.compare(s1.getId(), s2.getId());
            }
        });
        for (int i=0;i<n;i++)
        {
            System.out.println(a.get(i).getName());
        }
    }
}