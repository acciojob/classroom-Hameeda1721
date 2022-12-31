package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class StudentRepository {
    private static HashMap<String, Student> studentHashMap;
    private static HashMap<String, Teacher> teacherHashMap;
    private static HashMap<String, List<String>> studentTeacherHashMap;

    public StudentRepository() {
        this.studentHashMap = new HashMap<String, Student>();
        this.teacherHashMap = new HashMap<String, Teacher>();
        this.studentTeacherHashMap = new HashMap<String, List<String>> ();
    }

    public static void addStudentToRepository(Student student) {
        studentHashMap.put(student.getName(),student);
    }

    public static void addTeacherToRepository(Teacher teacher) {
        teacherHashMap.put(teacher.getName(),teacher);
    }

    public static void addStudentTeacherRepository(String student, String teacher) {
        List<String> studentsList=new ArrayList<>();
        if(studentHashMap.containsKey(student) && teacherHashMap.containsKey(teacher)){

            if(studentTeacherHashMap.containsKey(teacher)){
                studentsList=studentTeacherHashMap.get(teacher);

            }
            studentsList.add(student);
            studentTeacherHashMap.put(teacher,studentsList);
        }
    }

    public static Student getStudentByName(String name) {
        Student student=null;
        if(studentHashMap.containsKey(name)){
            student=studentHashMap.get(name);
        }
        return student;
    }

    public static Teacher getTeacherByName(String name) {
        Teacher teacher=null;
        if(teacherHashMap.containsKey(name)){
            teacher=teacherHashMap.get(name);
        }
        return teacher;
    }

    public static List<String> getStudentByTeacherName(String name) {
        List<String> students=new ArrayList<>();
        if(studentTeacherHashMap.containsKey(name)){
            students=studentTeacherHashMap.get(name);
        }
        return students;
    }

    public static List<String> getAllStudents() {
        List<String> students = new ArrayList<>();
        for(String student: studentHashMap.keySet()){
            students.add(student);
        }
        return students;
    }

    public static void deleteTeacherByName(String teacher) {
        List<String> students = new ArrayList<>();
        if(studentTeacherHashMap.containsKey(teacher)) {
            students = studentTeacherHashMap.get(teacher);

            for(String student: students){
                if(studentHashMap.containsKey(student)){
                    studentHashMap.remove(student);
                }
            }
            studentTeacherHashMap.remove(teacher);
        }
        if(teacherHashMap.containsKey(teacher)){
            teacherHashMap.remove(teacher);
        }
    }

    public static void deleteAllTeachers() {
        teacherHashMap = new HashMap<>();
        for(String teacher: studentTeacherHashMap.keySet()){
            List<String> students=new ArrayList<>();
            for(String studentName: studentTeacherHashMap.get(teacher)) {
                students.add(studentName);
            }
            for(String name: students){
                if(studentHashMap.containsKey(name)){
                    studentHashMap.remove(name);
                }
            }
        }
        studentTeacherHashMap=new HashMap<>();
    }
}
