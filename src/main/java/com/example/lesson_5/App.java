package com.example.lesson_5;

import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        for (int i = 0, j = 1;  i < 100; i++, j++) {
            studentDao.add(new Student("Name_" + (i + 1), j));
            if (j == 5) {
                j = 0;
            }
        }

        Student test = new Student("Name", 3);
        studentDao.add(test);
        test.setName("Fil");
        studentDao.update(test);
        System.out.println(studentDao.getName(101));
        studentDao.delete(100);
        studentDao.delete("Fil");

        List<Student> students = studentDao.getAll();
        for (Student s: students) {
            System.out.format("id: %d name: %s mark: %d\n", s.getId(), s.getName(), s.getMark());
        }

        studentDao.closeSessionFactory();

    }
}
