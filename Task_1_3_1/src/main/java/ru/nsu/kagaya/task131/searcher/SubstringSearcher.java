package ru.nsu.kagaya.task131.searcher;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для поиска подстроки.
 */
public class SubstringSearcher {
    //степень для полиномиального хеша
    private static final int BASE = 257;

    /**
     *Функция находящая подстроку в строке
     * при помощи полиномиального хеша.
     *
     * @param path - путь до файла со строкой.
     * @param substring - искомая подстрока.
     * @return массив с вхождениями.
     * @throws IOException исключение, если не удалось считать файл.
     */
    public static List<Integer> find(String path, String substring)
            throws IOException {

        int substringLength = substring.length();
        int wantedHash = getHash(substring);
        //считаем степень для подстроки по длине
        int basePow = 1;
        for (int i = 0; i < substringLength - 1; i++) {
            basePow *= BASE;
        }

        List<Integer> lst = new ArrayList<>();

        try (var br = Files.newBufferedReader(Path.of(path),
                StandardCharsets.UTF_8)) {

            StringBuilder stringBuilder = new StringBuilder(substringLength);
            for (int i = 0; i < substringLength; i++) {
                int ch = br.read();
                if (ch == -1) {
                    return lst; //файл слишком короткий
                }
                stringBuilder.append((char) ch);
            }
            int currentHash = getHash(stringBuilder.toString());

            int index = 0;
            if (currentHash == wantedHash
                    && stringBuilder.toString().equals(substring)) {
                lst.add(index);
            }
            index++;

            int charCode;
            while ((charCode = br.read()) != -1) {
                Character removedChar = stringBuilder.charAt(0);
                Character addedChar = (char) charCode;
                stringBuilder.append(addedChar);
                stringBuilder.deleteCharAt(0);

                currentHash = (currentHash - removedChar.hashCode() * basePow) * BASE
                        + addedChar.hashCode();
                if (currentHash == wantedHash
                        && stringBuilder.toString().equals(substring)) {
                    lst.add(index);
                }
                index++;
            }
        }
        return lst;
    }

    private static int getHash(String substring) {
        int result = 0;
        for (int i = 0; i < substring.length(); i++) {
            result = result * BASE + substring.charAt(i);
        }
        return result;
    }
}