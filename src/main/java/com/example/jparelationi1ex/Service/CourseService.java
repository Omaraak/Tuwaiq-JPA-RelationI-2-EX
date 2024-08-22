package com.example.jparelationi1ex.Service;

import com.example.jparelationi1ex.Api.ApiException;
import com.example.jparelationi1ex.Model.Course;
import com.example.jparelationi1ex.Model.Teacher;
import com.example.jparelationi1ex.Repository.CourseRepository;
import com.example.jparelationi1ex.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public void add(Course course) {
        courseRepository.save(course);
    }

    public void update(int id, Course course) throws ApiException {
        Course c = courseRepository.findCourseById(id);
        if (c == null){
            throw new ApiException("Course not found");
        }
        c.setName(course.getName());
        courseRepository.save(c);
    }

    public void delete(int id) throws ApiException {
        Course course = courseRepository.findCourseById(id);
        if (course == null){
            throw new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }

    public Course findCourseById(int id) throws ApiException {
        Course course = courseRepository.findCourseById(id);
        if (course == null){
            throw new ApiException("Course not found");
        }
        return course;
    }

    public void assignCourse(int teacherID, int courseID) throws ApiException {
        Course course = courseRepository.findCourseById(courseID);
        if (course == null){
            throw new ApiException("Course not found");
        }
        Teacher teacher = teacherRepository.findTeacherById(teacherID);
        if (teacher == null){
            throw new ApiException("Teacher not found");
        }
        course.setTeacher(teacher);
        courseRepository.save(course);
    }
}
