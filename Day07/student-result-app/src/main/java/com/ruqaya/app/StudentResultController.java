package com.ruqaya.app;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentResultController {

    private Map<String, StudentResult> studentResultMap = new HashMap<>();

    @GetMapping("/get/studentResult")
    public StudentResult getStudentResult(@RequestParam String name){
        StudentResult result= studentResultMap.get(name);
        return result;
    }

    @GetMapping("/get/all")
    public Map<String,StudentResult> getStudentResult(){ return studentResultMap; }

    @PostMapping("/save/studentResult")
    public void SaveStudentResult(@RequestBody @NotNull StudentResult studentResult){
        String name= studentResult.getName();
        studentResultMap.put(name,studentResult);
    }

    @PutMapping("/update/studentResult")
    public StudentResult updateStudentResult(@RequestParam String name,@RequestParam String schoolName){
        StudentResult result= studentResultMap.get(name);
        result.setSchoolName(schoolName);
        studentResultMap.put(name,result);
        return result;

    }

    @DeleteMapping("/remove/studentResult")
    public void deleteStudentResult(@RequestParam String name){
        studentResultMap.remove(name);
    }
}