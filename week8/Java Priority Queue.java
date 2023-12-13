
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>((s1,s2) -> {
            if (s1.getCGPA() != s2.getCGPA()) {
                return Double.compare(s2.getCGPA(), s1.getCGPA());
            } else if (!s1.getName().equals(s2.getName())) {
                return s1.getName().compareTo(s2.getName()); 
            } else {
                return Integer.compare(s1.getID(), s2.getID());
            }
        });

        for (String event : events) {
            String[] payloads = event.split(" ");
            if (payloads[0].equals("ENTER")) {
                String name = payloads[1];
                double cgpa = Double.parseDouble(payloads[2]);
                int id = Integer.parseInt(payloads[3]);
                pq.offer(new Student(id, name, cgpa));
            } else  {
                pq.poll(); 
            }
        }

        List<Student> res = new ArrayList<>();
        while (!pq.isEmpty()) 
        {
            Student s = pq.poll();
            res.add(s);
        }

        return res;
    }
}

