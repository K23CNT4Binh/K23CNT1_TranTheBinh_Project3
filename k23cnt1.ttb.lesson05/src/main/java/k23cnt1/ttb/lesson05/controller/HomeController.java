package k23cnt1.ttb.lesson05.controller;

import k23cnt1.ttb.lesson05.entity.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Devmaster::Trang chủ");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        List<Info> profile = new ArrayList<>();

        // Tạo dữ liệu profile mẫu
        profile.add(new Info(
                "Devmaster Academy",
                "dev",
                "DevMaster",
                "contact@devmaster.edu.vn",
                "https://devmaster.edu.vn",
                "Học viện lập trình hàng đầu Việt Nam",
                "0123456789"
        ));

        profile.add(new Info(
                "Nguyen Van A",
                "nguyena",
                "AkaNguyen",
                "nguyena@example.com",
                "https://example.com",
                "Developer",
                "0987654321"
        ));

        model.addAttribute("DevmasterProfile", profile);
        return "profile";
    }
}
