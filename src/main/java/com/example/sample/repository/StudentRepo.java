package com.example.sample.repository;

import com.example.sample.Entity.Student;
import com.example.sample.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {
}
