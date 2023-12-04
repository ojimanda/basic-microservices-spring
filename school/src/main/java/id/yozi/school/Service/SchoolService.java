package id.yozi.school.Service;

import id.yozi.school.Client.StudentClient;
import id.yozi.school.Model.School;
import id.yozi.school.Model.dto.StudentSchoolResponse;
import id.yozi.school.Repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    private final StudentClient studentClient;

    public void saveStudent(School school) {
        schoolRepository.save(school);
    }

    public List<School> findSchools() {
        return schoolRepository.findAll();
    }


    public StudentSchoolResponse findSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId).orElse(
                School.builder()
                        .name("NOT_FOUND")
                        .email("NOT_FOUND")
                        .build()
        );
        var students = studentClient.findAllStudentsBySchool(schoolId);
        return StudentSchoolResponse.builder()
                .name(school.getName())
                .email(school.getEmail())
                .studentList(students)
                .build();
    }
}
