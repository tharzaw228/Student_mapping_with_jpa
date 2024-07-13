package org.example.studentmapping.dao;

import org.example.studentmapping.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectDao extends JpaRepository<Subject, Long> {
}
