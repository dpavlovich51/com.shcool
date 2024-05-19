package com.school.student.contoller;

import com.school.student.entity.StudentEntity;
import com.school.student.model.NewStudentDto;
import com.school.student.model.Student;
import com.school.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public Page<Student> getAll(Student student, Pageable pageable) {
        return studentService.getAll(student, pageable)
                .map(it -> new Student(it.getId(), it.getName(), it.getCourse()));
    }

    @PostMapping
    public Student createStudent(@RequestBody @Valid NewStudentDto student) {
        StudentEntity newStudent = studentService.createStudent(StudentEntity.builder()
                .id(UUID.randomUUID())
                .name(student.getName())
                .course(student.getCourse())
                .build());

        return toDto(newStudent);
    }

    private static Student toDto(StudentEntity student) {
        return new Student(student.getId(), student.getName(), student.getCourse());
    }

}
