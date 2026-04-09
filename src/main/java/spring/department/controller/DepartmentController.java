package spring.department.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.department.service.DepartmentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/department")
public class DepartmentController {
    private final DepartmentService departmentService;

}
