package k23cnt1.ttb.lesson06.repository;

import k23cnt1.ttb.lesson06.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Bạn có thể thêm các method tùy chỉnh nếu cần
}
