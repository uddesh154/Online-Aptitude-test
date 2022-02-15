package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.TeacherModel;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel,Long> {

	public TeacherModel findByEmailAndPassword(String email,String password);
}
