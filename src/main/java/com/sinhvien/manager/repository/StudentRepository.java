package com.sinhvien.manager.repository;

import com.sinhvien.manager.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Bạn có thể thêm hàm tìm kiếm theo mã sinh viên nếu cần
    Student findByStudentCode(String studentCode);
    List<Student> findByFullNameContainingIgnoreCaseOrStudentCodeContainingIgnoreCase(String name, String code);
}
