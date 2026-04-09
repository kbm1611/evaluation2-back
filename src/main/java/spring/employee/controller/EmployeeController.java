package spring.employee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.employee.dto.EmployeeDto;
import spring.employee.service.EmployeeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {
    private final EmployeeService employeeSvc;

    @PostMapping
    public ResponseEntity<?> addEmp(@ModelAttribute EmployeeDto empDto){
        return ResponseEntity.ok( employeeSvc.addEmp( empDto ) );
    }

    @DeleteMapping
    public ResponseEntity<?> delEmp(@RequestParam Integer emp_id){
        return ResponseEntity.ok( employeeSvc.delEmp( emp_id ) );
    }

    @PutMapping
    public ResponseEntity<?> updEmp(@RequestBody EmployeeDto empDto){
        return ResponseEntity.ok( employeeSvc.updEmp( empDto ) );
    }

    @GetMapping
    public ResponseEntity<?> findAllEmp(){
        return ResponseEntity.ok( employeeSvc.findAllEmp() );
    }
}
