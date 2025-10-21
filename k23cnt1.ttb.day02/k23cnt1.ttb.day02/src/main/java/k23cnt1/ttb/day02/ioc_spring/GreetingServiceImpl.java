package k23cnt1.ttb.day02.ioc_spring;

import org.springframework.stereotype.Service;
@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet(String name) {
        return "<h2>BinhGold[Spring Boot!] Xin chào,</h2> " +
                "<h1 style='color:red; text-align:center'>" +
                name;
    }
}
