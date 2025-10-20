package com.ttb.lesson01.lambda_expression;

public class LambdaExpression2 {
    public static void main(String[] args) {
        // Lambda dùng 1 tham số
        SayHello2 say1 = (name) -> {
            System.out.println("Hello " + name);
        };
        say1.sayHello("Binh Gold");

        // Viết ngắn gọn hơn
        SayHello2 say2 = name -> {
            System.out.println("Hello " + name);
        };
        say2.sayHello("Binh Gold");

        // Viết ngắn gọn nhất
        SayHello2 say3 = name -> System.out.println("Hello " + name);
        say3.sayHello("Binh Gold");
    }
}
