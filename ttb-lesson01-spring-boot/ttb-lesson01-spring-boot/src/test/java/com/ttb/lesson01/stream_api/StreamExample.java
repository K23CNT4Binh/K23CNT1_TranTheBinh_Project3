package com.ttb.lesson01.stream_api;

import java.util.Arrays;
import java.util.List;

public class StreamExample {

    // Dữ liệu mẫu (sử dụng Arrays.asList để tạo nhanh một List)
    List<Integer> integerList = Arrays.asList(11, 22, 55, 33, 44, 66);

    // --- 1. Phương thức đếm số chẵn KHÔNG dùng Stream (cách truyền thống) ---
    public void withoutStream() {
        int count = 0;
        for (Integer integer : integerList) {
            if (integer % 2 == 0) { // Kiểm tra số chẵn
                count++;
            }
        }
        System.out.println("WithoutStream -> Số phần tử chẵn: " + count);
    }

    // --- 2. Phương thức đếm số chẵn DÙNG Stream ---
    public void withStream() {
        // stream(): tạo luồng dữ liệu
        // filter(): giữ lại các phần tử thỏa mãn điều kiện (num % 2 == 0)
        // count(): trả về số lượng phần tử còn lại trong luồng
        long count = integerList.stream()
                .filter(num -> num % 2 == 0)
                .count();
        System.out.println("WithStream -> Số phần tử chẵn: " + count);
    }

    // --- 3. Phương thức chính (Main) để thực thi ---
    public static void main(String[] args) {
        StreamExample streamExample = new StreamExample();

        // Gọi cả hai phương thức để so sánh kết quả và cú pháp
        streamExample.withoutStream();
        streamExample.withStream();
    }
}