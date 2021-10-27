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

        // Getting attributes infos
        Converter converter = new Converter(c);
        converter.fetchFields();

        // Getting methods signatures
        /*Method[] classMethods = c.getDeclaredMethods();
        for (Method method : classMethods) {
            System.out.print("Method : ");
            String[] methodString = method.toGenericString().split(" ");
            System.out.print("access - " + methodString[0]);
            System.out.print(" // return type - " + methodString[1]);
            System.out.println(" // name and args - " + methodString[2]);
        }
        System.out.println();*/

        // Getting methods signatures
        /*Constructor[] classConstructors = c.getDeclaredConstructors();
        for (Constructor constructor : classConstructors) {
            System.out.print("Method : ");
            String[] constructorString = constructor.toGenericString().split(" ");
            System.out.print("access - " + constructorString[0]);
            System.out.println(" // name and args - " + constructorString[1]);
        }
        System.out.println();*/
    }
}
