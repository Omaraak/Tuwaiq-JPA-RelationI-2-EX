package com.example.jparelationi1ex.Repository;

import com.example.jparelationi1ex.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findCourseById(int id);
}
