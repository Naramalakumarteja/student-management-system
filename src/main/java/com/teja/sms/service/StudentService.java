package com.teja.sms.service;

import com.teja.sms.exception.StudentNotFoundException;
import com.teja.sms.entity.Student;
import com.teja.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(
                                "Student not found with id " + id));
    }

    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            student.setName(updatedStudent.getName());
            student.setEmail(updatedStudent.getEmail());
            student.setDepartment(updatedStudent.getDepartment());
            student.setYear(updatedStudent.getYear());

            return studentRepository.save(student);
        }

        return null;
    }

    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }

    public Page<Student> getStudentsByDepartmentWithPagination(
            String department,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        return studentRepository.findByDepartment(
                department,
                pageable);
    }

    public Page<Student> getStudentsWithPagination(
            int page,
            int size,
            String sortBy) {

        Pageable pageable =
                PageRequest.of(page, size, Sort.by(sortBy));

        return studentRepository.findAll(pageable);
    }
}