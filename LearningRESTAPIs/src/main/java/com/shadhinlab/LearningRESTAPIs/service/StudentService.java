package com.shadhinlab.LearningRESTAPIs.service;

import com.shadhinlab.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.shadhinlab.LearningRESTAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface StudentService {

    List<StudentDto> getAllStudent();

    StudentDto getAllStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
