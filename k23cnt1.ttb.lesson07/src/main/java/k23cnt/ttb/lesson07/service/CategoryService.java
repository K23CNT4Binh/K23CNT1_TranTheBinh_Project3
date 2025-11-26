package k23cnt.ttb.lesson07.service;

import k23cnt.ttb.lesson07.entity.Category;
import k23cnt.ttb.lesson07.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Lấy tất cả category
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Lấy category theo id
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Tạo hoặc cập nhật category
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Xóa category theo id
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
