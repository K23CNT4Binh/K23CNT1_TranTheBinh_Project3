package k23cnt1.ttb.lesson08.controller;

import k23cnt1.ttb.lesson08.entity.Author;
import k23cnt1.ttb.lesson08.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    // Hiển thị danh sách tất cả author
    @GetMapping
    public String listAuthors(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "author/author-list"; // resources/templates/author/author-list.html
    }

    // Hiển thị form thêm mới
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        model.addAttribute("actionUrl", "/authors/save");
        return "author/author-form"; // dùng chung form
    }

    // Xử lý lưu author mới
    @PostMapping("/save")
    public String createAuthor(@ModelAttribute("author") Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }

    // Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
        model.addAttribute("author", author);
        model.addAttribute("actionUrl", "/authors/update/" + id);
        return "author/author-form";
    }

    // Xử lý cập nhật author
    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute("author") Author author) {
        author.setId(id);
        authorRepository.save(author);
        return "redirect:/authors";
    }

    // Xóa author
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
        authorRepository.delete(author);
        return "redirect:/authors";
    }
}
