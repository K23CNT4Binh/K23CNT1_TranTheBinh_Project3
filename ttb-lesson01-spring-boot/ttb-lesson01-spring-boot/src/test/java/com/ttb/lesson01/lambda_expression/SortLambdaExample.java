package com.ttb.lesson01.lambda_expression;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortLambdaExample {
    public static void main(String[] args) {
        // Tạo danh sách chuỗi
        List<String> list = Arrays.asList("Java SpringBoot", "C# NetCore", "PHP", "JavaScript");

        // Sắp xếp danh sách bằng biểu thức Lambda
        Collections.sort(list, (str1, str2) -> str1.compareTo(str2));

        // In kết quả sau khi sắp xếp
        for (String str : list) {
            System.out.println(str);
        }
    }
}
