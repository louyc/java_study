package lyc.restlet.resource;

import java.util.HashMap;

import lyc.restlet.modle.Student;
import lyc.restlet.modle.Teacher;

public class StorageOperator {
    public static int studentID = 1;
    public static int teacherID = 1;
    
    public static HashMap<Integer, Student> students = new HashMap<Integer, Student>();
    public static HashMap<Integer, Teacher> teachers = new HashMap<Integer, Teacher>();
    
    static {
        Student student = new Student();
        student.setId(1);
        student.setGrade(3);
        student.setName("Scott");
        student.setSex(0);
        student.setAge(18);
        students.put(student.getId(), student);
        
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setSubject("MATH");
        teacher.setName("Toney");
        teacher.setSex(1);
        teacher.setAge(27);
        teachers.put(teacher.getId(), teacher);
    }

    public static Student findStudent(int id) {
        return students.get(id);
    }

    public static int addStudent(Student student) {
        students.put(student.getId(), student);
        return student.getId();
    }

    public static int updateStudent(Student student) {
        return addStudent(student);
    }

    public static int deleteStudent(int id) {
        if (students.get(id) != null) {
            students.remove(id);
            return 1;
        }
        return 0;
    }
    
    public static Teacher findTeacher(int id) {
        return teachers.get(id);
    }

    public static int addTeacher(Teacher teacher) {
        teachers.put(teacher.getId(), teacher);
        return teacher.getId();
    }

    public static int updateTeacher(Teacher teacher) {
        return addTeacher(teacher);
    }

    public static int deleteTeacher(int id) {
        if (teachers.get(id) != null) {
            teachers.remove(id);
            return 1;
        }
        return 0;
    }

}