package org.kyi.webfluxapidemo.service.impl;

import lombok.RequiredArgsConstructor;
import org.kyi.webfluxapidemo.model.Student;
import org.kyi.webfluxapidemo.repository.StudentRepository;
import org.kyi.webfluxapidemo.service.StudentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Flux<Student> saveAllStudents(Flux<Student> students) {
        return studentRepository.saveAll(students);
    }

    @Override
    public Mono<Student> updateStudent(Student student, Long studentId) {
        return studentRepository.findById(studentId)
                .flatMap(existingStudent -> {
                    existingStudent.setFirstName(student.getFirstName());
                    existingStudent.setLastName(student.getLastName());
                    existingStudent.setAge(student.getAge());

                    return studentRepository.save(existingStudent);
                });
    }

    @Override
    public Mono<Student> saveSingleStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Mono<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Flux<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        studentRepository.deleteById(id);
        return "Student with ID: " + id + " deleted";
    }

}
