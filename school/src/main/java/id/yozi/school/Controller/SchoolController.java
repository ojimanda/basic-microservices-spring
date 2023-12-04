package id.yozi.school.Controller;

import id.yozi.school.Model.School;
import id.yozi.school.Model.dto.StudentSchoolResponse;
import id.yozi.school.Service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody School school
            ) {

        schoolService.saveStudent(school);

    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(schoolService.findSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<StudentSchoolResponse> findAllStudents(
            @PathVariable("school-id") Integer schoolId
    ) {
        return ResponseEntity.ok(schoolService.findSchoolsWithStudents(schoolId));
    }

}
