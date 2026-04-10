package spring.employee.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.common.service.FileService;
import spring.department.entity.DepartmentEntity;
import spring.department.repository.DepartmentRepository;
import spring.employee.dto.EmployeeDto;
import spring.employee.entity.EmployeeEntity;
import spring.employee.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final DepartmentRepository departmentRepo;
    private final FileService fileService;

    // 사원 등록
    public boolean addEmp(EmployeeDto empDto){
        DepartmentEntity departmentEntity = departmentRepo.findByDeptName(empDto.getDept_name());
        EmployeeEntity employeeEntity = empDto.toEntity();
        employeeEntity.setDepartmentEntity(departmentEntity);

        // 파일처리
        String fileName = fileService.upload(empDto.getUploadFile() );
        if(fileName != null) employeeEntity.setProfileImage( fileName );
        else employeeEntity.setProfileImage( "https://placehold.co/100x100");

        return employeeRepo.save( employeeEntity ).getEmpId() > 0;
    }

    // 시원 전체 목록 조회
    public List<EmployeeDto> findAllEmp(){
        return employeeRepo.findAll().stream()
                .map(EmployeeEntity::toDto)
                .toList();
    }

    // 사원 삭제
    public boolean delEmp(Integer emp_id){
        boolean exists = employeeRepo.existsById(emp_id);
        if(exists){
            employeeRepo.deleteById(emp_id);
            return true;
        }
        return false;
    }

    // 사원 수정
    public boolean updEmp(EmployeeDto empDto){
        Optional<EmployeeEntity> optional = employeeRepo.findById( empDto.getEmp_id() );

        if(optional.isPresent()){
            EmployeeEntity employeeEntity = optional.get();
            employeeEntity.setEmpName(empDto.getEmp_name());
            employeeEntity.setPosition(empDto.getPosition());
            return true;
        }
        return false;
    }
}
