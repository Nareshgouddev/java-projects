package com.app;
import java.util.List;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.app.Entity.Student;
import com.app.Service.StudentService;

@SpringBootApplication
public class SpringDataJpa3Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext c = SpringApplication.run(SpringDataJpa3Application.class, args);
        StudentService s = c.getBean(StudentService.class);
        AiService aiService = c.getBean(AiService.class);
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Find Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. FindAll Student");
            System.out.println("6. Ask AI about Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1 -> {
                    System.out.println("Enter Roll No:");
                    Integer roll_No = sc.nextInt();
                    System.out.println("Enter Name:");
                    String name = sc.next();
                    System.out.println("Enter Course:");
                    String course = sc.next();
                    System.out.println("Enter CGPA:");
                    Double cgpa = sc.nextDouble();
                    System.out.println("Enter GPA:");
                    Double gpa = sc.nextDouble();
                    Student student = new Student(roll_No, name, course, cgpa, gpa);
                    s.save(student);
                    System.out.println("Student Saved: " + student);
                }

                case 2 -> {
                    System.out.println("Enter Roll_No to Find:");
                    Integer id = sc.nextInt();
                    s.findByid(id).ifPresentOrElse(
                        st -> System.out.println("Found: " + st),
                        ()  -> System.out.println("Student Not Found!")
                    );
                }

                case 3 -> {
                    System.out.println("Enter Roll No to Update:");
                    Integer id = sc.nextInt();
                    System.out.println("Enter New Name:");
                    String newName = sc.next();
                    Student updated = s.updateStudent(id, newName);
                    System.out.println("Updated: " + updated);
                }
                case 4 -> {
                    System.out.println("Enter Roll No to Delete:");
                    Integer id = sc.nextInt();
                    s.delete(id);
                    System.out.println("Student Deleted Successfully!");
                }
                case 5 ->{
                	List<Student> l=s.findAll();
                	for(Student x:l) {
                		System.out.println(x);
                	}
                }
                case 6 -> {
                    System.out.println("Ask AI anything about students:");
                    sc.nextLine();
                    String question = sc.nextLine();
                    aiService.chat(question);
                }
                case 7 -> {
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice! Enter 1-5");
            }
        }
    }
}