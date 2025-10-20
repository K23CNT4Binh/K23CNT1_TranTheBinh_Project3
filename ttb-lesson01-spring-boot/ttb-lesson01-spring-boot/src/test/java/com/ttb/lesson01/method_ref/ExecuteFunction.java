package com.ttb.lesson01.method_ref;

interface ExecuteFunction {
    public int execute(int a, int b);
}

class MathUtils {

    public MathUtils() { }

    public MathUtils(String str) {
        System.out.println("MathUtils:" + str);
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}