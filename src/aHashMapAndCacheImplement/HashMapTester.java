package aHashMapAndCacheImplement;


import java.util.HashMap;
import java.util.Map;

public class HashMapTester {
    public static void main(String[] args) {
        // 创建一个 HashMap 来存储学生的学号和姓名
        Map<Integer, String> studentMap = new HashMap<>();

        // 添加学生信息到 HashMap
        studentMap.put(1001, "张三");
        studentMap.put(1002, "李四");
        studentMap.put(1003, "王五");
        studentMap.put(1004, "王五");
        studentMap.put(1004, "A er");

        // 查找学生信息
        int studentIdToFind = 1002;
        if (studentMap.containsKey(studentIdToFind)) {
            String studentName = studentMap.get(studentIdToFind);
            System.out.println("学生 " + studentIdToFind + " 的姓名是：" + studentName);
        } else {
            System.out.println("未找到学生 " + studentIdToFind + " 的信息");
        }

        // 遍历 HashMap 中的所有学生信息
        System.out.println("所有学生的信息：");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            int studentId = entry.getKey();
            String studentName = entry.getValue();
            System.out.println("学生 " + studentId + " 的姓名是：" + studentName);
        }
    }
}
