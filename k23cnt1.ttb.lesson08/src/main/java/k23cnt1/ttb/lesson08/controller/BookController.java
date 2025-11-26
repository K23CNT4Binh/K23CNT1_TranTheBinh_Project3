package k23cnt1.ttb.lesson08.controller;

import k23cnt1.ttb.lesson08.entity.Author;
import k23cnt1.ttb.lesson08.entity.Book;
import k23cnt1.ttb.lesson08.service.AuthorService;
import k23cnt1.ttb.lesson08.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    private static final String UPLOAD_DIR = "src/main/resources/static/images/products/";

    // Hiển thị danh sách sách
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/book-list";
    }

    // Form tạo mới sách
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/book-form";
    }

    // Lưu sách mới
    @PostMapping("/new")
    public String saveBook(@ModelAttribute Book book,
                           @RequestParam(value = "authorIds", required = false) List<Long> authorIds,
                           @RequestParam("imageBook") MultipartFile imageFile) {

        // Upload ảnh nếu có
        if (!imageFile.isEmpty()) {
            try {
                Path uploadPath = Paths.get(UPLOAD_DIR);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String originalFilename = StringUtils.cleanPath(imageFile.getOriginalFilename());
                String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
                String newFileName = book.getCode() + fileExtension;

                Path filePath = uploadPath.resolve(newFileName);
                Files.copy(imageFile.getInputStream(), filePath);

                // Lưu đường dẫn tương đối để Thymeleaf hiển thị
                book.setImgUrl("/images/products/" + newFileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Gán authors
        if (authorIds != null) {
            List<Author> authors = new ArrayList<>(authorService.findAllById(authorIds));
            book.setAuthors(authors);
        }

        bookService.saveBook(book);
        return "redirect:/books";
    }

    // Form sửa sách
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/book-form";
    }

    // Xóa sách
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
