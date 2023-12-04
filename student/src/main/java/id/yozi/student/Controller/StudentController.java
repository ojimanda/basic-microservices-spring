package id.yozi.student.Controller;

import id.yozi.student.Model.Student;
import id.yozi.student.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Student student
            ) {

        studentService.saveStudent(student);

    }

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok(studentService.findStudents());
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findStudentsBySchool(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(studentService.findStudentsBySchoolId(schoolId));
    }

}
