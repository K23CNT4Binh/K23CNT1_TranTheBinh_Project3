package k23cnt.ttb.lesson07.controller;

import k23cnt.ttb.lesson07.entity.Category;
import k23cnt.ttb.lesson07.entity.Product;
import k23cnt.ttb.lesson07.repository.CategoryRepository;
import k23cnt.ttb.lesson07.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryRepository categoryRepository;

    // Hiển thị danh sách sản phẩm
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/products-list"; // file: templates/products/products.html
    }

    // Hiển thị form tạo mới sản phẩm
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepository.findAll());
        return "products/products-form"; // file: templates/products/products-form.html
    }

    // Xử lý tạo mới sản phẩm
    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid category Id"));
        product.setCategory(category);
        productService.saveProduct(product);
        return "redirect:/products";
    }

    // Hiển thị form chỉnh sửa sản phẩm
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id"));
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryRepository.findAll());
        return "products/products-form"; // file: templates/products/products-form.html
    }

    // Xử lý xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
