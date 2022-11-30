package com.example.lesson_7.services;

import com.example.lesson_7.model.Student;
import com.example.lesson_7.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final  StudentRepository studentRepository;

    public List<Student> findAll() {
        return Collections.unmodifiableList(studentRepository.findAll());
    }

    public void add(String name, int age) {
        studentRepository.save(new Student(name, age));
    }

    public Optional<Student> get(int id) {
        return studentRepository.findById(id);
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    public void updateName(int id, String name) {
        studentRepository.updateName(id, name);
    }

    public void updateAge(int id, int age) {
        studentRepository.updateAge(id, age);
    }
}
