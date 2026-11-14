package ru.nsu.kagaya.task131;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how OpenIDE suggests fixing it.

        var lst = SubstringSearcher.find("C:\\Users\\Denis\\OOP\\Task_1_3_1\\src\\main\\resources\\input.txt", "бра");
        System.out.print(lst);
    }
}