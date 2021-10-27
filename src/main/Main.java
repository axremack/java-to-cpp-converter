package main;

import converter.Fetcher;
import converter.Writer;

public class Main {
    public static void main(String[] args) throws Exception {
        String class_name = "example.Example";
        Class c = Class.forName(class_name);

        Fetcher fetcher = new Fetcher(c);
        //fetcher.fetchFields();
        //fetcher.fetchConstructors();
        //fetcher.fetchMethods();

        StringBuilder sb = new StringBuilder();
        String fileToCreate = c.getName();
        Writer writer = new Writer(fetcher, fileToCreate, sb);

        writer.writeFile();

    }
}
