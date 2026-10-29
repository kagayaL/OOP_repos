package ru.nsu.kagaya.task122;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HashTable<String, Number> hashTable = new HashTable<>();

        hashTable.add("one", 1);
        System.out.println("after add:      " + hashTable);

        hashTable.setValue("one", 1.0);
        System.out.println("get(one):       " + hashTable.getValue("one"));


        hashTable.add("two", 2);
        hashTable.add("three", 3);
        System.out.println("after adds:     " + hashTable);

        //has
        System.out.println("has 'two':      " + hashTable.hasValue("two"));
        System.out.println("has 'four':     " + hashTable.hasValue("four"));

        //remove
        hashTable.remove("two");
        System.out.println("after remove:   " + hashTable);



        //equals
        HashTable<String, Number> other = new HashTable<>();
        other.add("one", 1.0);
        other.add("three", 3);
        System.out.println("equals:         " + hashTable.equals(other));

        //hashCode
        System.out.println("hashCode:       " + hashTable.hashCode());
        System.out.println("other hash:     " + other.hashCode());

        //итерация
        System.out.println("iteration:");
        for (Node<String, Number> node : hashTable) {
            System.out.println("  " + node.getKey() + " - " + node.getValue());
        }


    }
}