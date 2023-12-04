package id.yozi.student.Service;

import id.yozi.student.Model.Student;
import id.yozi.student.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findStudents() {
        return studentRepository.findAll();
    }


    public List<Student> findStudentsBySchoolId(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
