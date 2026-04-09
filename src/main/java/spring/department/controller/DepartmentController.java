package spring.department.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.department.dto.DepartmentDto;
import spring.department.service.DepartmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:5173")
public class DepartmentController {
    private final DepartmentService departmentSvc;

    // 부서 컨트롤러 구현해야 할 기능: 부서 추가, 부서 수정, 부서 삭제, 부서 전체 조회
    @PostMapping
    public ResponseEntity<?> addDept(@RequestBody DepartmentDto deptDto){
        return ResponseEntity.ok( departmentSvc.addDept( deptDto ) );
    }

    @DeleteMapping
    public ResponseEntity<?> delDept(@RequestParam Integer dept_id){
        return ResponseEntity.ok( departmentSvc.delDept( dept_id ) );
    }

    @PutMapping
    public ResponseEntity<?> updDept(@RequestBody DepartmentDto deptDto){
        return ResponseEntity.ok( departmentSvc.updDept( deptDto ) );
    }

    @GetMapping
    public ResponseEntity<?> findAllDept(){
        return ResponseEntity.ok( departmentSvc.findAllDept() );
    }

}
