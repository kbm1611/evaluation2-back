package spring.department.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.department.entity.DepartmentEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {
    private Integer dept_id;
    private String dept_name;

    private String createAt;
    private String updateAt;

    public DepartmentEntity toEntity(){
        return DepartmentEntity.builder()
                .deptId(dept_id)
                .deptName(dept_name)
                .build();
    }
}
