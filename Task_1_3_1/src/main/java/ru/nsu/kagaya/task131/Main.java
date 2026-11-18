package ru.nsu.kagaya.task131;

import java.io.IOException;

import ru.nsu.kagaya.task131.searcher.SubstringSearcher;

/**
 * Класс с точкой входа.
 */
public class Main {
    /**
     * Точка входа.
     *
     * @param args нет аргументов.
     * @throws IOException бросает исключение, если ошибка доступа к файлу.
     */
    public static void main(String[] args) throws IOException {

        var lst = SubstringSearcher.find("C:\\Users\\Denis\\OOP\\Task_1_3_1\\src\\main\\resources\\input.txt", "бра");
        System.out.print(lst);
    }
}