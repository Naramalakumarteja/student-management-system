package com.teja.sms.controller;

import com.teja.sms.entity.Student;
import com.teja.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody Student updatedStudent) {

        return studentService.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
    

    @GetMapping("/search/name")
    public List<Student> searchByName(
            @RequestParam String name) {

        return studentService.getStudentsByName(name);
    }

    @GetMapping("/search/department")
    public List<Student> getStudentsByDepartment(
            @RequestParam String department) {

        return studentService.getStudentsByDepartment(department);
    }

    @GetMapping("/search/department/paginated")
    public Page<Student> getStudentsByDepartmentWithPagination(
            @RequestParam String department,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return studentService.getStudentsByDepartmentWithPagination(
                department,
                page,
                size);
    }

    @GetMapping("/paginated")
    public Page<Student> getStudentsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return studentService.getStudentsWithPagination(
                page,
                size,
                sortBy);
    }
}