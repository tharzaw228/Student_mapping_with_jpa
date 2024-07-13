package org.example.studentmapping.dao;

import org.example.studentmapping.ds.StudentInfo;
import org.example.studentmapping.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentDao extends JpaRepository<Student, Long>, CustomStudentRepository{


    Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Student s where s.firstName = :firstName and s.lastName = :lastName")
    Optional<Student> getFistNameLastNameByStudent(@Param("firstName") String firstName,
                                                   @Param("lastName") String lastName);

    @Query("""
    select new org.example.studentmapping.ds.StudentInfo(p.provinceName,s.firstName,s.lastName,stsub.marks,sub.subjectName) 
    from Province p join p.students s 
    join s.studentSubjects stsub join stsub.subject sub 
    where sub.subjectName = :subjectName 
    and stsub.marks = (select max(sdb.marks) from StudentSubject sdb  where sdb.subject.subjectName = :subjectName)   
""")

    Optional<StudentInfo> findStudentInfo(@Param("subjectName") String subjectName);
}
