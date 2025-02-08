package com.demo_rest.demo_rest_crud.rest;

import com.demo_rest.demo_rest_crud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Bruce", "Wayne"));
        theStudents.add(new Student("Clark", "Kent"));
        theStudents.add(new Student("Bruce", "Almighty"));
    }
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return theStudents;
    }
    @GetMapping("/students/{studentId}")
    public Student getStudent (@PathVariable int studentId) {
        // check the studentId against the list size
        if((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        return theStudents.get(studentId);
    }
}
