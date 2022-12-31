package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public static void addStudent(Student student) {
        StudentRepository.addStudentToRepository(student);

    }

    public static void addTeacher(Teacher teacher) {
        StudentRepository.addTeacherToRepository(teacher);
        
    }

    public static void addStudentTeacherPair(String student, String teacher) {
        StudentRepository.addStudentTeacherRepository(student,teacher);
    }

    public static Student getStudentByName(String name) {
        Student student=StudentRepository.getStudentByName(name);
        return student;
    }

    public static Teacher getTeacherByName(String name) {
        return StudentRepository.getTeacherByName(name);
    }

    public static List<String> getStudentsByTeacherName(String teacher) {
        return StudentRepository.getStudentByTeacherName(teacher);
    }

    public static List<String> getAllStudents() {
        return StudentRepository.getAllStudents();
    }

    public static void deleteTeacherByName(String teacher) {
         StudentRepository.deleteTeacherByName(teacher);
    }

    public static void deleteAllTeachers() {
        StudentRepository.deleteAllTeachers();
    }
}
