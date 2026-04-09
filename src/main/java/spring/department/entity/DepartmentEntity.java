package spring.department.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.common.entity.BaseTime;
import spring.department.dto.DepartmentDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "department")
public class DepartmentEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;

    @Column(nullable = false, unique = true, length = 255)
    private String deptName;

    public DepartmentDto toDto(){
        return DepartmentDto.builder()
                .dept_id(deptId)
                .dept_name(deptName)
                .createAt(getCreateAt().toString())
                .updateAt(getUpdataAt().toString())
                .build();
    }
}
