package ru.nsu.kagaya.task113;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseVariables {

    public static Map<String, Integer> parse(String variables) {

        Map<String, Integer> valuesMap = new HashMap<String, Integer>();

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
