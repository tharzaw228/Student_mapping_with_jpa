package org.example.studentmapping.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
public class Subject extends IDClass {

    private String subjectName;
    private double fees;
    private int duration;
    @OneToMany(mappedBy = "subject")
    private List<StudentSubject> studentSubjects = new ArrayList<>();

    public Subject(String subjectName, double fees, int duration) {
        this.subjectName = subjectName;
        this.fees = fees;
        this.duration = duration;
    }

    public void addStudentSubject(StudentSubject studentSubject) {
        studentSubject.setSubject(this);
        studentSubjects.add(studentSubject);
    }
}
