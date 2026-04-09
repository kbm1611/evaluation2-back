package spring.department.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.department.dto.DepartmentDto;
import spring.department.entity.DepartmentEntity;
import spring.department.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepo;

    // 부서 추가
    public boolean addDept(DepartmentDto deptDto){
        return departmentRepo.save( deptDto.toEntity() ).getDeptId() > 0;
    }

    // 부서 삭제
    public boolean delDept(Integer dept_id){
        boolean exists = departmentRepo.existsById(dept_id);
        if(exists){
            departmentRepo.deleteById(dept_id);
            return true;
        }
        return false;
    }

    // 부서 수정
    public boolean updDept(DepartmentDto deptDto){

        Optional<DepartmentEntity> optional = departmentRepo.findById( deptDto.getDept_id() );
        if(optional.isPresent()){
            DepartmentEntity departmentEntity = optional.get();
            departmentEntity.setDeptName(deptDto.getDept_name());
            return true;
        }
        return false;
    }

    // 부서 전체 조회
    public List<DepartmentDto> findAllDept(){
        return departmentRepo.findAll()
                .stream()
                .map(DepartmentEntity::toDto)
                .toList();
    }

}
