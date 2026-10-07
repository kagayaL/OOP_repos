package ru.nsu.kagaya.task113.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс для парсинга переменных и их значений в хеш таблицу.
 */
public class ParseVariables {
    /**
     * Превращает строки вида:
     * name1 = value1 ; name2 = value2 ; ...
     * в хеш таблицу name - value.
     *
     * @param variables строка с переменными и значениями.
     * @return хеш таблица name - value.
     */
    public static Map<String, Integer> parse(String variables) {

        Map<String, Integer> valuesMap = new HashMap<String, Integer>();

        if (variables == null || variables.isBlank()) {
            return valuesMap;
        }

        variables = variables.replace(" ", "");
        List<String> variablesList = List.of(variables.split(";"));

        for (String pair : variablesList) {
            List<String> mapPair = List.of(pair.split("="));

            String key = mapPair.get(0);
            Integer value = Integer.valueOf(mapPair.get(1));

            valuesMap.put(key, value);
        }

        return valuesMap;
    }
}
