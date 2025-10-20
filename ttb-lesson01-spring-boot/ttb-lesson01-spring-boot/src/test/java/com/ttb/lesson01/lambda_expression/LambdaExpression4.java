package com.ttb.lesson01.lambda_expression;

import java.util.Arrays;
import java.util.List;

public class LambdaExpression4 {
    public static void main(String[] args) {
        // Tạo danh sách chuỗi
        List<String> list = Arrays.asList("Java SpringBoot", "C#", "NetCore", "PHP", "JavaScript");

        // Duyệt danh sách bằng biểu thức Lambda
        list.forEach(item -> System.out.println(item));

        System.out.println("=================");

        // Cách viết ngắn gọn hơn (method reference)
        list.forEach(System.out::println);
    }
}
