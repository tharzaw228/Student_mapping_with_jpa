package org.example.studentmapping.dao;

import org.example.studentmapping.entity.StudentSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSubjectDao extends JpaRepository<StudentSubject, Long> {
}
