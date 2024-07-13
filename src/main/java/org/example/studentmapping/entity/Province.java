package org.example.studentmapping.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Province extends IDClass {
    private String provinceName;

    public Province(String provinceName) {
        this.provinceName = provinceName;
    }

    @OneToMany(mappedBy = "province", cascade = CascadeType.PERSIST)
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        student.setProvince(this);
        students.add(student);
    }

}
