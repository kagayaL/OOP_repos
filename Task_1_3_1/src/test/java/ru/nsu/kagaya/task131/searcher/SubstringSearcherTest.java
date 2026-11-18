package ru.nsu.kagaya.task131.searcher;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class SubstringSearcherTest {

    @TempDir
    Path tempDir;

    @Test
    void findInLargeFile() throws IOException {
        Path file = tempDir.resolve("input.txt");

        int count = 6_000_000;
        String peace = "р*бота_суббота ";   // 12 символов + пробел

        try (BufferedWriter bw = Files.newBufferedWriter(
                file, StandardCharsets.UTF_8)) {
            for (int i = 0; i < count; i++) {
                bw.write(peace);
            }
        }

        List<Integer> result = SubstringSearcher.find(file.toString(), "бота");

        assertEquals(count * 2, result.size());
    }
}