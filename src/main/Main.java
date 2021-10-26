package main;

import example.Example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String class_name = "example.Example";
        Class c = Class.forName(class_name);
        System.out.println(c.getName());

        // Getting attributes infos
        Field[] classFields = c.getDeclaredFields();
        for (Field field : classFields) {
            System.out.print("Field : ");
            String[] fieldString = field.toGenericString().split(" ");
            System.out.print("access - " + fieldString[0]);
            System.out.print(" // type - " + fieldString[1]);
            System.out.println(" // name - " + fieldString[2]);
        }
        System.out.println();

        // Getting methods signatures
        Method[] classMethods = c.getDeclaredMethods();
        for (Method method : classMethods) {
            System.out.print("Method : ");
            String[] methodString = method.toGenericString().split(" ");
            System.out.print("access - " + methodString[0]);
            System.out.print(" // return type - " + methodString[1]);
            System.out.println(" // name and args - " + methodString[2]);
        }
        System.out.println();


    }
}
