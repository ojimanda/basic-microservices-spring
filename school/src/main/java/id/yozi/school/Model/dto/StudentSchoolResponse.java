package id.yozi.school.Model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentSchoolResponse {

    private String name;
    private String email;
    List<Student> studentList;

}
