package org.example.studentmapping.service;


import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.studentmapping.dao.*;
import org.example.studentmapping.ds.StudentInfo;
import org.example.studentmapping.entity.Province;
import org.example.studentmapping.entity.Student;
import org.example.studentmapping.entity.StudentSubject;
import org.example.studentmapping.entity.Subject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final ProvinceDao provinceDao;
    private final StudentDao studentDao;
    private final SubjectDao subjectDao;
    private final StudentSubjectDao studentSubjectDao;


    public Student findStudentByFirstNameAndLastName(String firstName, String lastName) {
        return studentDao.getStudentFirstNameAndLastName(firstName,lastName);
    }

    public StudentInfo findMaxMarksStudentIn(String subjectName) {
        return  studentDao.findStudentInfo(subjectName)
                .orElseThrow(()-> new EntityNotFoundException("No student found with subject name " + subjectName));
    }

    @Transactional
    public void createDb() {
        Province province1 = new Province("Sule");
        Province province2 = new Province("Hlaing");
        Province province3 = new Province("Dagon");

        Student student1 = new Student("John","Doe", "john@gmail.com", "ISM");
        Student student2 = new Student("John", "Willim", "william@gmail.com", "ISM");
        Student student3 = new Student("John", "Lenon", "lenon@gmail.com", "IMY");
        Student student4 = new Student("Charles", "Dickens", "dickens@gmail.com", "PSM");
        Student student5 = new Student("Freddie", "Murcury", "murcury@gmail.com", "LA");
        Student student6 = new Student("Bon", "Jovi", "jovi@gmail.com", "FBI");

        Subject subject1 = new Subject("Java", 6, 5000);
        Subject subject2 = new Subject("Python", 6, 5000);
        Subject subject3 = new Subject("JavaScript", 6, 5000);

        province1.addStudent(student1);
        province1.addStudent(student2);

        province2.addStudent(student3);
        province2.addStudent(student4);

        province3.addStudent(student5);
        province3.addStudent(student6);

        //student1 - Java - 90
        StudentSubject studentSubject1 = new StudentSubject();
        studentSubject1.setMarks(90);
        student1.addStudentSubject(studentSubject1);
        subject1.addStudentSubject(studentSubject1);

        //Student1 - Python  - 80
        StudentSubject studentSubject2 = new StudentSubject();
        studentSubject2.setMarks(80);
        student2.addStudentSubject(studentSubject2);
        subject2.addStudentSubject(studentSubject2);

        //Student2 Java - 90
        StudentSubject studentSubject3 = new StudentSubject();
        studentSubject3.setMarks(90);
        student2.addStudentSubject(studentSubject3);
        subject1.addStudentSubject(studentSubject3);

        //Student3 python - 85
        StudentSubject studentSubject4 = new StudentSubject();
        studentSubject4.setMarks(80);
        student3.addStudentSubject(studentSubject4);
        subject2.addStudentSubject(studentSubject4);

        //Student 3 java - 75
        StudentSubject studentSubject5 = new StudentSubject();
        studentSubject5.setMarks(75);
        student3.addStudentSubject(studentSubject5);
        subject1.addStudentSubject(studentSubject5);


        //Student 4 Java - 70
        StudentSubject studentSubject6 = new StudentSubject();
        studentSubject6.setMarks(70);
        student4.addStudentSubject(studentSubject6);
        subject1.addStudentSubject(studentSubject6);

        //Student 4 JS - 100
        StudentSubject studentSubject7 = new StudentSubject();
        studentSubject7.setMarks(100);
        student4.addStudentSubject(studentSubject7);
        subject3.addStudentSubject(studentSubject7);

        //Student5 Js - 40
        StudentSubject studentSubject8 = new StudentSubject();
        studentSubject8.setMarks(40);
        student5.addStudentSubject(studentSubject8);

        //Student 6 Python - 90
        StudentSubject studentSubject9 = new StudentSubject();
        studentSubject9.setMarks(90);
        student6.addStudentSubject(studentSubject9);
        subject2.addStudentSubject(studentSubject9);

        //Student 6 Java - 90
        StudentSubject studentSubject10 = new StudentSubject();
        studentSubject10.setMarks(90);
        student6.addStudentSubject(studentSubject9);
        subject1.addStudentSubject(studentSubject9);

        //Student 6 Js - 90
        StudentSubject studentSubject11 = new StudentSubject();
        studentSubject11.setMarks(90);
        student6.addStudentSubject(studentSubject9);
        subject3.addStudentSubject(studentSubject9);

        provinceDao.save(province1);
        provinceDao.save(province2);
        provinceDao.save(province3);

        subjectDao.save(subject3);
        subjectDao.save(subject1);
        subjectDao.save(subject2);
    }
}
