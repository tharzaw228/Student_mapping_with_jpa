package org.example.studentmapping.dao;

import org.example.studentmapping.entity.Student;

public interface CustomStudentRepository {
    Student getStudentFirstNameAndLastName(String firstName, String lastName);
}
