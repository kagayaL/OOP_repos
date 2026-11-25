package ru.nsu.kagaya.task141.model;

import java.util.ArrayList;
import java.util.List;

public class GradeBook {
    private static final int EXCELLENT = 5;
    private static final int GOOD = 4;
    private static final int SATISFACTORY = 3;
    private static final double RED_DIPLOMA_RATIO = 0.75;
    private static final int MIN_SESSIONS_FOR_BUDGET = 2;

    private final List<Semester> semesters;
    private final int totalSemesterCount;
    private boolean isBudget;

    public GradeBook(int totalSemesterCount, boolean isBudget) {
        this.totalSemesterCount = totalSemesterCount;
        this.semesters = new ArrayList<>();
        this.isBudget = isBudget;
    }

    public void addSemester(Semester semester) {
        semesters.add(semester);
    }

    public float getAverageGrade() {
        int totalValue = 0;
        int totalCount = 0;
        for (var semester : semesters) {
            for (var grade : semester.getGrades()) {
                totalValue += grade.value();
                totalCount++;
            }
        }
        if (totalCount == 0) return 0f;
        return (float)totalValue / totalCount;
    }

    public boolean transferToBudget() {
        //уже на бюджете перевод невозможен
        if (isBudget) return false;
        //если сессий меньше 2х то на бюджет нельзя
        if (semesters.size() < MIN_SESSIONS_FOR_BUDGET) return false;

        var firstSemester = semesters.get(semesters.size() - 1);
        var secondSemester = semesters.get(semesters.size() - 2);

        for (var grade : firstSemester.getGrades()) {
            if (acceptGrade(grade)) continue;
            return false;
        }

        for (var grade : secondSemester.getGrades()) {
            if (acceptGrade(grade)) continue;
            return false;
        }

        isBudget = true;
        return true;
    }

    public boolean canGetRedDiploma() {
        int currentFives = 0;
        int totalGrades = 0;

        for (var semester : semesters) {
            for (var grade : semester.getGrades()) {
                if (grade.discipline().controlType() == ControlType.DEFENCE_VKR
                        && grade.value() < EXCELLENT) {
                    return false;
                }
                if ((grade.discipline().controlType() == ControlType.EXAM
                        || grade.discipline().controlType() == ControlType.DIFF)
                        && grade.value() == SATISFACTORY) {
                    return false;
                }

                if (grade.value() == EXCELLENT) {
                    currentFives++;
                }
                totalGrades++;
            }
        }

        if (totalGrades == 0) return false;
        return (double) currentFives / totalGrades >= RED_DIPLOMA_RATIO;
    }

    public boolean canGetIncreasedScholarship() {
        if (semesters.isEmpty()) {
            return false;
        }

        var lastSemester = semesters.get(semesters.size() - 1);

        for (var grade : lastSemester.getGrades()) {
            if (grade.value() <= GOOD) {
                return false;
            }
        }

        return true;
    }

    private boolean acceptGrade(Grade grade) {
        if (grade.discipline().controlType() == ControlType.EXAM) {
            return grade.value() > SATISFACTORY;
        }
        if (grade.discipline().controlType() == ControlType.DIFF) {
            return grade.value() >= SATISFACTORY;
        }
        return true;
    }
}