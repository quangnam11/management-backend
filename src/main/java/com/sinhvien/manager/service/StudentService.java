package com.sinhvien.manager.service;

import com.sinhvien.manager.exception.ResourceNotFoundException;
import com.sinhvien.manager.model.Student;
import com.sinhvien.manager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> searchStudents(String keyword) {
        return studentRepository.findByFullNameContainingIgnoreCaseOrStudentCodeContainingIgnoreCase(keyword, keyword);
    }
    
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);
        
        student.setStudentCode(studentDetails.getStudentCode());
        student.setFullName(studentDetails.getFullName());
        student.setEmail(studentDetails.getEmail());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setAddress(studentDetails.getAddress());
        
        return studentRepository.save(student);
    }
    
    public Student getStudentById(Long id) {
    return studentRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Sinh vien khong ton tai voi id: " + id));
}

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
    
    
}
