package ru.nsu.kagaya.task131;

import ru.nsu.kagaya.task131.searcher.SubstringSearcher;

import java.io.IOException;

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