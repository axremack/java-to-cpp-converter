package main;

import example.Example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String class_name = "example.Example";
        Class c = Class.forName(class_name);
        System.out.println(c.getName());

        // Getting attributes name, access and type
        Field[] classFields = c.getDeclaredFields();
        for (Field field : classFields) {
            System.out.print("Field : ");
            System.out.print("type - " + field.getType());
            System.out.println(" // name and access - " + field.toGenericString());
        }



    }
}
