package ru.nsu.kagaya.task122.hashtable;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Параметризованная хеш-таблица.
 * Разрешение коллизий — цепочки.
 *
 * @param <K> тип ключа.
 * @param <V> тип значения.
 */
public class HashTable<K, V> implements Iterable<HashTable.Node<K, V>> {

    private static final int START_BUCKET_COUNT = 16;
    private static final double LOAD_FACTOR = 0.7;

    private final List<Node<K, V>> buckets;
    private int modificationCount;
    private int pairsCount;

    /**
     * Создаёт пустую хештаблицу.
     */
    public HashTable() {
        pairsCount = 0;
        modificationCount = 0;
        buckets = new ArrayList<>(START_BUCKET_COUNT);
        for (int i = 0; i < START_BUCKET_COUNT; i++) {
            buckets.add(null);
        }
    }

    /**
     * Добавляет пару ключ-значение.
     * если есть значение меняем.
     *
     * @param key ключ.
     * @param value значение.
     */
    public void add(K key, V value) {
        int hash = Math.abs(key.hashCode() % buckets.size());

        if (buckets.get(hash) == null) {
            buckets.set(hash, new Node<>(key, value));
            pairsCount++;
        } else {
            var currentNode = buckets.get(hash);

            while (true) {

                //если уже есть узел с таким значением - перезапись
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    break;
                }

                currentNode = currentNode.getNextNode();

                if (currentNode.getNextNode() == null) {
                    var newNode = new Node<>(key, value);
                    currentNode.setNextNode(newNode);
                    newNode.setPreviousNode(currentNode);
                    pairsCount++;
                    break;
                }
            }
        }

        if ((double)pairsCount / buckets.size() > LOAD_FACTOR) {

        }
    }

    /**
     * Удаляет пару по ключу.
     *
     * @param key ключ.
     * @return удалённое значение.
     */
    public V remove(K key) {
        int hash = Math.abs(key.hashCode() % buckets.size());
        Node<K, V> currentNode = buckets.get(hash);
        Node<K, V> previousNode = null;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                V removedValue = currentNode.getValue();

                if (previousNode == null) {
                    buckets.set(hash, currentNode.getNextNode());
                } else {
                    previousNode.setNextNode(currentNode.getNextNode());
                }
                if (currentNode.getNextNode() != null) {
                    currentNode.getNextNode().setPreviousNode(previousNode);
                }

                pairsCount--;
                modificationCount++;
                return removedValue;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    /**
     * Возвращает значение по ключу.
     *
     * @param key ключ.
     * @return значение.
     */
    public V getValue(K key) {
        int hash = Math.abs(key.hashCode() % buckets.size());
        Node<K, V> currentNode = buckets.get(hash);

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    /**
     * Обновляет значение по ключу.
     *
     * @param key ключ.
     * @param value новое значение.
     * @throws RuntimeException если ключа нет.
     */
    public void setValue(K key, V value) {
        int hash = Math.abs(key.hashCode() % buckets.size());
        Node<K, V> currentNode = buckets.get(hash);

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                currentNode.setValue(value);
                modificationCount++;
                return;
            }
            currentNode = currentNode.getNextNode();
        }
        throw new RuntimeException("Ключа " + key + " нет");
    }

    /**
     * Проверяет наличие ключа.
     *
     * @param key ключ.
     * @return true, если ключ есть.
     */
    public boolean hasValue(K key) {
        int hash = Math.abs(key.hashCode() % buckets.size());
        Node<K, V> currentNode = buckets.get(hash);

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return true;
            }
            currentNode = currentNode.getNextNode();
        }
        return false;
    }

    /**
     * Возвращает итератор по парам.
     *
     * @return итератор.
     */
    @Override
    public Iterator<Node<K, V>> iterator() {
        return new HashTableIterator();
    }

    /**
     * Сравнивает две хештаблицы.
     *
     * @param other другая таблица.
     * @return true, если пары совпадают.
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object other) {

        if (other == null ||
                this.getClass() != other.getClass()) {
            return false;
        }

        HashTable<K, V> otherHashTable = (HashTable<K, V>) other;

        if (this.pairsCount != otherHashTable.pairsCount) {
            return false;
        }

        for (var node : this) {
            K myKey = node.getKey();
            V myValue = node.getValue();

            if (!otherHashTable.hasValue(myKey)) {
                return false;
            } else if (!Objects.equals(otherHashTable.getValue(myKey), myValue)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Хешкод таблицы.
     *
     * @return хешкод.
     */
    @Override
    public int hashCode() {
        int totalHash = 0;

        for (var node : this) {
            K myKey = node.getKey();
            V myValue = node.getValue();
            totalHash += Objects.hashCode(myKey) + Objects.hashCode(myValue);
        }

        return totalHash;
    }

    /**
     * Строковое представление таблицы.
     *
     * @return строка вида {key : value; }.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (Node<K, V> node : this) {
            sb.append(node.getKey());
            sb.append(" : ");
            sb.append(node.getValue());
            sb.append("; ");
        }

        sb.append("}");
        return sb.toString();
    }

    /**
     * Итератор по парам таблицы.
     */
    private class HashTableIterator implements Iterator<Node<K, V>> {
        private final int expectedModificationCount = modificationCount;
        private Node<K, V> nextNode = null;
        private int currentBucketIndex = 0;

        public HashTableIterator() {
            advance();
        }

        @Override
        public boolean hasNext() {
            checkForModification();
            return nextNode != null;
        }

        @Override
        public Node<K, V> next() {
            checkForModification();
            if (!hasNext()) {
                throw new RuntimeException("Элементы кончились");
            }
            Node<K, V> currentNode = nextNode;
            advance();
            return currentNode;
        }

        private void checkForModification() {
            if (modificationCount != expectedModificationCount) {
                throw new ConcurrentModificationException("Таблица была изменена");
            }
        }

        private void advance() {
            if (nextNode != null && nextNode.getNextNode() != null) {
                nextNode = nextNode.getNextNode();
                return;
            }
            //смотрим некст бакеты
            currentBucketIndex++;
            while (currentBucketIndex < buckets.size()) {
                Node<K, V> head = buckets.get(currentBucketIndex);
                if (head != null) {
                    nextNode = head;
                    return;
                }
                currentBucketIndex++;
            }
            //элементы кончились
            nextNode = null;
        }
    }

    /**
     * Узел хеш-таблицы.
     *
     * @param <K> тип ключа.
     * @param <V> тип значения.
     */
    public static class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> previousNode;
        private Node<K, V> nextNode;

        /**
         * Создаёт узел.
         *
         * @param key ключ.
         * @param value значение.
         */
        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.previousNode = null;
            this.nextNode = null;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Node<K, V> getPreviousNode() {
            return previousNode;
        }

        public Node<K, V> getNextNode() {
            return nextNode;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setPreviousNode(Node<K, V> newPreviousNode) {
            previousNode = newPreviousNode;
        }

        public void setNextNode(Node<K, V> newNextNode) {
            nextNode = newNextNode;
        }
    }
}