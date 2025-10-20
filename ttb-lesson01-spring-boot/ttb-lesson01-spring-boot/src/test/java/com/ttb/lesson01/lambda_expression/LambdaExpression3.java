package com.ttb.lesson01.lambda_expression;

public class LambdaExpression3 {
    public static void main(String[] args) {

        // Lambda với 2 tham số (có kiểu dữ liệu)
        Calculator1 calc1 = (int a, int b) -> (a + b);
        System.out.println(calc1.add(11, 12));

        // Lambda với 2 tham số (rút gọn, bỏ kiểu dữ liệu)
        Calculator1 calc2 = (a, b) -> (a + b);
        System.out.println(calc2.add(21, 22));

        // Lambda không trả về giá trị (void)
        Calculator2 calc3 = (a, b) -> System.out.println(a + b);
        calc3.add(31, 32);
    }
}
