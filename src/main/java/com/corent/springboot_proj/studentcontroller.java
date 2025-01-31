/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.corent.springboot_proj;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author shrisaiaravind
 */
@RestController
public class studentcontroller {

    List<student> stuList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @GetMapping("/students")
    public List<student> getAllStudents() {
        return stuList;
    }

    @GetMapping("/student/roll/{rollNo}")
    public student getStudentWithId(@PathVariable Integer rollNo) {
        for (student s : stuList) {
            if (s.getRollNo() == rollNo) {
                return s;
            }
        }
        return null;
    }

    @PostMapping("/newstudent")
    public void addStudent(@RequestBody student s) {
        stuList.add(s);
    }
    
    @PostMapping("/newstudents")
    public void addStudent(@RequestBody List<student> lis) {
        for(student st: lis){
            stuList.add(st);
        }
    }

    @DeleteMapping("/deletestudent/{rollNo}")
    public void deleteStudent(@PathVariable Integer rollNo) {
        Iterator<student> itr = stuList.iterator();
        while (itr.hasNext()) {
            student s = itr.next();
            if (s.getRollNo() == rollNo) {
                itr.remove();
            }
        }
    }
    @GetMapping("/student")
    public List<student> findStudent(
            @RequestParam(name = "section", required=false) String section,
            @RequestParam(name = "standard", required=false) Integer standard,
            @RequestParam(name = "age", required=false) Integer age,
            @RequestParam(name = "name", required=false) String name)
            {
            List<student> matchedStudents = new ArrayList<>();
            for (student s : stuList) {
            boolean match = true;

            if (section != null && !s.getSection().equalsIgnoreCase(section)) {
                match = false;
            }
            if (standard != null && s.getStandard() != standard) {
                match = false;
            }
            if (age != null && s.getAge() != (age)) {
                match = false;
            }
            if (name != null && !s.getName().equalsIgnoreCase(name)) {
                match = false;
            }
            if (match) {
                matchedStudents.add(s);
            }
        }
            return matchedStudents;
    }
    
    @PutMapping("/updatestudent")
    public void updateStudent(
        @RequestParam(name = "rolNo", required = false) Integer rollNo,
        @RequestParam(name = "section", required = false) String section,
        @RequestParam(name = "standard", required = false) Integer standard,
        @RequestParam(name = "age", required = false) Integer age,
        @RequestParam(name = "name", required = false) String name,
        @RequestBody student updatedStudent) {

        boolean updated = false;

        for (student s : stuList) {
            boolean match = true;

            if (section != null && !s.getSection().equalsIgnoreCase(section)) {
                match = false;
            }
            if (standard != null && s.getStandard() != standard) {
                match = false;
            }
            if (age != null && s.getAge() != age) {
                match = false;
            }
            if (rollNo != null && s.getRollNo()!= rollNo) {
                match = false;
            }
            if (name != null && !s.getName().equalsIgnoreCase(name)) {
                match = false;
            }

            if (match) {
                s.setStandard(updatedStudent.getStandard());
                s.setSection(updatedStudent.getSection());
                s.setAge(updatedStudent.getAge());
                s.setRollNo(updatedStudent.getRollNo());
                updated = true;
            }
        }

    }
}
