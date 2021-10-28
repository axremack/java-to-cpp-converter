package main;

import converter.Fetcher;
import converter.Writer;

public class Main {
    public static void main(String[] args) throws Exception {
        String javaClass = args[0];
        String fileToCreate;
        Boolean printFileContent = false;

        if (args.length > 3 || args.length == 0){
            System.err.println("Usage : main.java Class.java [Class.cpp] [--stdout]");
            throw new IllegalArgumentException();
        }
        else if (args.length == 3){
            if (args[2].equals("--stdout")){
                printFileContent = true;
            } else {
                System.err.println("Usage : main.java Class.java [Class.cpp] [--stdout]");
                throw new IllegalArgumentException();
            }
            fileToCreate = args[1];
        }
        else if (args.length == 2){
            fileToCreate = args[1];
        }
        else {
            fileToCreate = javaClass;
        }

        Class c = Class.forName(javaClass);
        Fetcher fetcher = new Fetcher(c);
        StringBuilder sb = new StringBuilder();
        Writer writer = new Writer(fetcher, fileToCreate, sb);

        writer.writeFile(printFileContent);
    }
}
