package com.school.student.service;

import com.school.student.entity.StudentEntity;
import com.school.student.model.Student;
import com.school.student.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static com.school.student.util.StringUtils.isNotBlank;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepo studentRepo;

    public Page<StudentEntity> getAll(Student student, Pageable pageable) {
        if (student.getId() != null) {
            return studentRepo.findAll(Specification.where((root, query, cb) ->
                    cb.equal(root.get(StudentEntity.Fields.id), student.getId())), pageable);
        }
        Specification<StudentEntity> spec = Specification.where((root, query, cb) ->
                cb.isNotNull(root.get(StudentEntity.Fields.id)));

        if (isNotBlank(student.getName())) {
            spec = spec.and((root, query, cb) ->
                    cb.like(root.get(StudentEntity.Fields.name), student.getName() + "%"));
        }
        if (isNotBlank(student.getCourse())) {
            spec = spec.and((root, query, cb) ->
                    cb.like(root.get(StudentEntity.Fields.course), student.getCourse() + "%"));
        }
        return studentRepo.findAll(spec, pageable);
    }

    public StudentEntity createStudent(StudentEntity newStudent) {
        return studentRepo.save(newStudent);
    }
}
