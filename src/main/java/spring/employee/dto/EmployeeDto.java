package spring.employee.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;
import spring.employee.entity.EmployeeEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Integer emp_id;
    private String emp_name;
    private String position;
    private String profileImage;

    private MultipartFile uploadFile;

    private String dept_name;

    private String createAt;
    private String updateAt;

    public EmployeeEntity toEntity(){
        return EmployeeEntity.builder()
                .empId(emp_id)
                .empName(emp_name)
                .position(position)
                .profileImage(profileImage)
                .build();
    }
}
