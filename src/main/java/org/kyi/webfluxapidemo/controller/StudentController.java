package org.kyi.webfluxapidemo.controller;

import lombok.RequiredArgsConstructor;
import org.kyi.webfluxapidemo.model.Student;
import org.kyi.webfluxapidemo.service.StudentService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/save")
    public Mono<Student> saveStudent(@RequestBody Student student) {
        return studentService.saveSingleStudent(student);
    }

    @PostMapping("/saveAll")
    public Flux<Student> saveAll(@RequestBody Flux<Student> students){
        return studentService.saveAllStudents(students);
    }

    @GetMapping("/student/{id}")
    public Mono<Student> fetchStudent(@PathVariable Long id){
        return studentService.findStudentById(id);
    }

    @GetMapping("/allStudents")
    public Flux<Student> getAllStudents(){
        return studentService.findAllStudents();
    }

    @PutMapping("/student/{id}")
    public Mono<Student> updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.updateStudent(student,id);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentService.deleteById(id);
    }


}

