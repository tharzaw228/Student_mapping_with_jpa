package org.example.studentmapping.dao;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.example.studentmapping.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomStudentRepositoryImpl implements CustomStudentRepository {

    private final EntityManager em;
    @Override
    public Student getStudentFirstNameAndLastName(String firstName, String lastName) {
        return em.createQuery("""
    select s from Student s where s.firstName = :firstName and s.lastName = :lastName
""",Student.class).setParameter("firstName",firstName)
                .setParameter("lastName",lastName).getSingleResult();
    }
}
