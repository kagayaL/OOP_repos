package ru.nsu.kagaya.task122.hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ConcurrentModificationException;
import org.junit.jupiter.api.Test;

class HashTableTest {

    @Test
    void addAndGet() {
        HashTable<String, Integer> t = new HashTable<>();
        t.add("one", 1);

        assertEquals(1, t.getValue("one"));
    }

    @Test
    void addUpdatesExistingKey() {
        HashTable<String, Integer> t = new HashTable<>();
        t.add("one", 1);
        t.add("one", 2);

        assertEquals(2, t.getValue("one"));
    }

    @Test
    void setValue() {
        HashTable<String, Integer> t = new HashTable<>();
        t.add("one", 1);
        t.setValue("one", 10);

        assertEquals(10, t.getValue("one"));
    }

    @Test
    void remove() {
        HashTable<String, Integer> t = new HashTable<>();
        t.add("one", 1);
        t.add("two", 2);

        assertEquals(1, t.remove("one"));
        assertFalse(t.hasValue("one"));
        assertEquals(2, t.getValue("two"));
    }

    @Test
    void hasValue() {
        HashTable<String, Integer> t = new HashTable<>();
        t.add("one", 1);

        assertTrue(t.hasValue("one"));
        assertFalse(t.hasValue("two"));
    }

    @Test
    void equalsTrue() {
        HashTable<String, Integer> a = new HashTable<>();
        HashTable<String, Integer> b = new HashTable<>();
        a.add("x", 1);
        b.add("x", 1);

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void equalsFalse() {
        HashTable<String, Integer> a = new HashTable<>();
        HashTable<String, Integer> b = new HashTable<>();
        a.add("x", 1);
        b.add("x", 2);

        assertNotEquals(a, b);
    }

    @Test
    void toStringFormat() {
        HashTable<String, Integer> t = new HashTable<>();
        t.add("x", 1);

        assertEquals("{x : 1; }", t.toString());
    }

    @Test
    void concurrentModification() {
        HashTable<String, Integer> t = new HashTable<>();
        t.add("a", 1);
        t.add("b", 2);

        var it = t.iterator();
        it.next();
        t.add("c", 3);

        assertThrows(ConcurrentModificationException.class, it::next);
    }

    @Test
    void resizeKeepsAllElements() {
        HashTable<Integer, Integer> t = new HashTable<>();
        for (int i = 0; i < 100; i++) {
            t.add(i, i * 10);
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(i * 10, t.getValue(i));
        }
    }
}