package com.school.student.repository;

import com.school.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface StudentRepo extends JpaRepository<StudentEntity, UUID>,
        JpaSpecificationExecutor<StudentEntity> {


}
