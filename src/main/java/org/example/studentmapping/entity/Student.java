package org.example.studentmapping.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends IDClass{
    private String firstName;
    private String lastName;
    private String email;
    private String school;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    private List<StudentSubject> studentSubjects = new ArrayList<>();

    public Student(String firstName, String lastName, String email, String school) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.school = school;
    }

    @ManyToOne
    private Province province;

    public void addStudentSubject(StudentSubject studentSubject) {
        studentSubject.setStudent(this);
        studentSubjects.add(studentSubject);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", school='" + school + '\'' +

                ", province=" + province.getProvinceName() +
                '}';
    }
}
