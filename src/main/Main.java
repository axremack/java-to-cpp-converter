package main;

import converter.Converter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String class_name = "example.Example";
        Class c = Class.forName(class_name);
        System.out.println(c.getName());

        Converter converter = new Converter(c);
        converter.fetchFields();
        converter.fetchConstructors();
        converter.fetchMethods();



    }
}
