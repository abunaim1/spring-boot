package com.shadhinlab.LearningRESTAPIs.service.impl;

import com.shadhinlab.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.shadhinlab.LearningRESTAPIs.dto.StudentDto;
import com.shadhinlab.LearningRESTAPIs.entity.Student;
import com.shadhinlab.LearningRESTAPIs.repository.StudentRepository;
import com.shadhinlab.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudent() {
        List <Student> students = studentRepository.findAll();
        return students.stream().map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail())).toList();
    }

    @Override
    public StudentDto getAllStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow( ()-> new IllegalArgumentException("Student does not match with this ID: "+id));
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by this ID"+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow( ()-> new IllegalArgumentException("Student does not match with this ID: "+id));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow( ()-> new IllegalArgumentException("Student does not match with this ID: "+id));

        updates.forEach((field, value) -> {
            switch (field){
                case "name" :
                    student.setName((String) value);
                    break;
                case "email" :
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not supported!");
            }
        });
        Student savedStudent = studentRepository.save(student);
        return modelMapper.map(savedStudent, StudentDto.class);
    }
}




























