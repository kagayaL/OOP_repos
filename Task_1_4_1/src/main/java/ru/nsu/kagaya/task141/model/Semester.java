package ru.nsu.kagaya.task141.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Semester {
    private final int number;
    private final Set<Discipline> disciplines;
    private final List<Grade> grades;

    public Semester(int number, List<Discipline> disciplines ) {
        this.number = number;
        this.disciplines = new LinkedHashSet<>(disciplines);
        this.grades = new ArrayList<>();
    }

    public void addGrade(Grade grade ) {
        disciplines.add(grade.discipline());
        grades.add(grade);
    }

    public void addDiscipline(Discipline discipline) {
        disciplines.add(discipline);
    }

    public int getNumber() {
        return number;
    }

    public Set<Discipline> getDisciplines() {
        return new LinkedHashSet<>(disciplines);
    }

    public List<Grade> getGrades() {
        return new ArrayList<>(grades);
    }
}