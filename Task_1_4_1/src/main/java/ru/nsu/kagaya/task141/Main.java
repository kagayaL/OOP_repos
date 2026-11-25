package ru.nsu.kagaya.task141;

import ru.nsu.kagaya.task141.model.*;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("--- ТЕСТ 1: Отличник (платник) ---");
        GradeBook book = getGradeBook();

        System.out.println("Средний балл: " + book.getAverageGrade());
        System.out.println("Повышенная стипендия: " + book.canGetIncreasedScholarship());

        System.out.println("Перевод на бюджет: " + book.transferToBudget());

        System.out.println("Красный диплом (прогноз): " + book.canGetRedDiploma());
    }

    private static GradeBook getGradeBook() {
        GradeBook book = new GradeBook(8, false); // 8 семестров, учится платно

        // 1 семестр
        Semester s1 = new Semester(1, new ArrayList<>());
        s1.addGrade(new Grade(5, new Discipline("Матанализ", ControlType.EXAM, 1)));
        s1.addGrade(new Grade(5, new Discipline("История", ControlType.CREDIT, 1)));
        book.addSemester(s1);

        // 2 семестр
        Semester s2 = new Semester(2, new ArrayList<>());
        s2.addGrade(new Grade(4,
                new Discipline("Физика", ControlType.EXAM, 2)));
        s2.addGrade(new Grade(5,
                new Discipline("Дискретка", ControlType.DIFF, 2)));
        book.addSemester(s2);
        return book;
    }
}