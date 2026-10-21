package ru.nsu.kagaya.task112.utils;

import ru.nsu.kagaya.task112.graph.bricks.Edge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс для чтения графа определенного формата.
 */
public class GraphReader {

    /**
     * Читает граф из файла.
     * Формат:
     * первая строка — количество вершин
     * далее строки вида "v1 v2" — рёбра.
     *
     * @param path путь до файла
     * @return данные графа
     * @throws IOException если файл не читается
     */
    public static GraphData readFromFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String firstLine = reader.readLine();
            if (firstLine == null) {
                return new GraphData(0, List.of());
            }

            int vertexCount = Integer.parseInt(firstLine.trim());
            List<Edge> edges = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                List<String> parts = Arrays.stream(line.split("\\s+")).toList();
                int from = Integer.parseInt(parts.get(0));
                int to = Integer.parseInt(parts.get(1));
                edges.add(new Edge(from, to));
            }

            return new GraphData(vertexCount, edges);
        }
    }
}