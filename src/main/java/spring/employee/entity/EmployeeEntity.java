package spring.employee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.common.entity.BaseTime;
import spring.department.entity.DepartmentEntity;
import spring.employee.dto.EmployeeDto;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmployeeEntity extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;

    @Column(nullable = false, length = 255)
    private String empName;

    @Column(nullable = false, length = 255)
    private String position;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private DepartmentEntity departmentEntity;

    @Column(length = 255)
    private String profileImage;

    public EmployeeDto toDto(){
        return EmployeeDto.builder()
                .emp_id(empId)
                .emp_name(empName)
                .position(position)
                .dept_name(departmentEntity.getDeptName())
                .profileImage(profileImage)
                .createAt(getCreateAt().toString())
                .updateAt(getUpdataAt().toString())
                .build();
    }

}
