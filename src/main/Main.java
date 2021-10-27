package main;

import converter.Fetcher;

public class Main {
    public static void main(String[] args) throws Exception {
        String class_name = "example.Example";
        Class c = Class.forName(class_name);
        System.out.println(c.getName());

        Fetcher fetcher = new Fetcher(c);
        fetcher.fetchFields();
        fetcher.fetchConstructors();
        fetcher.fetchMethods();




    }
}
