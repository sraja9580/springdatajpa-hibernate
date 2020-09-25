package com.raja.practice.datajpa.jpqlandnativesql.repos;

import com.raja.practice.datajpa.jpqlandnativesql.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface StudentRepo  extends CrudRepository<Student,Integer> {
    //IF YOU SELECT ALL THE COLUMN THEN IT GIVES STUDENT OBJECT OTHERWISE OBJECT ARRAY
    @Query("from Student")
    List<Student> getAllStudents();

    @Query("select firstName,lastName,score from Student")
    List<Object[]> getAllStudentsPartialData();

    //NAMED QUERY
    @Query("from Student where lastName=:lstName")
    List<Student> getAllStudentsWithLastName(@Param("lstName") String lastName);

    @Query("from Student where score>:minScore and score<:maxScore")
    List<Student> getAllStudentsBetweenScoreRange(@Param("minScore") Integer min,@Param("maxScore") Integer max);

    //NON SELECT OPERATION NEEDS @Modifying annotation, with out this spring wont consider it as DML and through exception
    @Modifying
    @Query("delete from Student where lastName=:lsName")
    void deleteStudentByLastName(@Param("lsName") String lastName);

    //PAGING
    @Query("from Student")
    List<Student> getAllStudentsWithPagingAndSorting(Pageable pageable);

    //NATIVE SQL
    @Query(value = "select * from student where lname=:lastNme",nativeQuery = true)
    List<Student> getAllStudentsWithLastNameNativeQuery(@Param("lastNme") String lastName);

}
