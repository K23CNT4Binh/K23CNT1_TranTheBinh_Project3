package k23cnt1.ttb.lesson08.repository; // sửa lại đúng chữ

import k23cnt1.ttb.lesson08.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // chữ hoa R

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
