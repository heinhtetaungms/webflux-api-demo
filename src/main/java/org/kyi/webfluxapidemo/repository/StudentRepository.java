package org.kyi.webfluxapidemo.repository;

import org.kyi.webfluxapidemo.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface StudentRepository extends ReactiveCrudRepository<Student, Long> {
    Flux<Student> findStudentsByFirstNameIgnoreCase(String firstName);
}
