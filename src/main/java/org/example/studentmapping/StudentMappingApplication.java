package org.example.studentmapping;

import lombok.RequiredArgsConstructor;
import org.example.studentmapping.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentMappingApplication implements CommandLineRunner {
    private final StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(StudentMappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        studentService.createDb();

        System.out.println("Find Student By fist Name and last Name");
        System.out.println(studentService.findStudentByFirstNameAndLastName("John", "Doe"));
        System.out.println("Max Marks In Java");
        System.out.println(studentService.findMaxMarksStudentIn("JavaScript"));
        JPAUtil.checkData("select * from province");
        JPAUtil.checkData("select * from student");
        JPAUtil.checkData("select * from subject");
        JPAUtil.checkData("select * from student_subject");
    }
}
