package converter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Writer {
    private Fetcher fetcher;
    private String className;
    private StringBuilder finalFileContent;

    // Constructor
    public Writer(Fetcher fetcher, String className, StringBuilder finalFileContent) {
        this.fetcher = fetcher;
        this.className = className;
        this.finalFileContent = finalFileContent;
    }

    // Getters and setters
    public Fetcher getFetcher() { return fetcher; }

    public void setFetcher(Fetcher fetcher) { this.fetcher = fetcher; }

    public String getClassName() { return className; }

    public void setClassName(String className) { this.className = className; }

    public StringBuilder getFinalFileContent() { return finalFileContent; }

    public void setFinalFileContent(StringBuilder finalFileContent) { this.finalFileContent = finalFileContent; }

    // Methods
    public void fetchClassInfos() {
        fetcher.fetchFields();
        fetcher.fetchConstructors();
        fetcher.fetchMethods();
    }

    public void writeClass() {
        finalFileContent.append("class " + className + " {\n");

        // Getting all the class infos
        List<Map<String,String>> listFieldInfos = fetcher.getAllFieldsInfos();
        List<Map<String,String>> listConstructorInfos = fetcher.getAllConstructorsInfos();
        List<Map<String,String>> listMethodInfos = fetcher.getAllMethodsInfos();

        // Private attributes, constuctors or methods
        finalFileContent.append("\tprivate :\n");

        listFieldInfos.stream()
                .filter(fieldInfos -> "private".equals(fieldInfos.get("access")))
                .forEach(fieldInfos -> finalFileContent.append("\t\t" + fieldInfos.get("type") + " " + fieldInfos.get("name") + ";\n"));

        listConstructorInfos.stream()
                .filter(constructorInfos -> "private".equals(constructorInfos.get("access")))
                .forEach(constructorInfos -> finalFileContent.append("\t\t" + constructorInfos.get("name") + "(" + constructorInfos.get("arguments") + ");\n"));

        listMethodInfos.stream()
                .filter(methodInfos -> "private".equals(methodInfos.get("access")))
                .forEach(methodInfos -> finalFileContent.append("\t\t" + methodInfos.get("return_type") + " " + methodInfos.get("name") + "(" + methodInfos.get("arguments") + ");\n"));

        finalFileContent.append("\n");

        // Public attributes, constuctors or methods
        finalFileContent.append("\tpublic :\n");

        listFieldInfos.stream()
                .filter(fieldInfos -> "public".equals(fieldInfos.get("access")))
                .forEach(fieldInfos -> finalFileContent.append("\t\t" + fieldInfos.get("type") + " " + fieldInfos.get("name") + ";\n"));

        listConstructorInfos.stream()
                .filter(constructorInfos -> "public".equals(constructorInfos.get("access")))
                .forEach(constructorInfos -> finalFileContent.append("\t\t" + constructorInfos.get("name") + "(" + constructorInfos.get("arguments") + ");\n"));

        listMethodInfos.stream()
                .filter(methodInfos -> "public".equals(methodInfos.get("access")))
                .forEach(methodInfos -> finalFileContent.append("\t\t" + methodInfos.get("return_type") + " " + methodInfos.get("name") + "(" + methodInfos.get("arguments") + ");\n"));

        finalFileContent.append("};\n")
                .append("\n");
    }

    public void writeDependancies() {
        List<String> dependancies = fetcher.getDependancies();

        for(String dependancy : dependancies) {
            finalFileContent.append(dependancy + "\n");
        }
        finalFileContent.append("\n");
    }

    public void writeFile() throws FileNotFoundException, UnsupportedEncodingException {
        fetchClassInfos();

        String completeFileName = className + ".hpp";
        PrintWriter writer = new PrintWriter(completeFileName, "UTF-8");

        // Writing guardians, dependancies and class informations
        String guardianName = className.toUpperCase() + "_" + "HPP";
        finalFileContent.append("#ifndef " + guardianName + "\n")
                        .append("#define " + guardianName + "\n")
                        .append("\n");

        writeDependancies();

        writeClass();

        finalFileContent.append("#endif\n");

        System.out.print(finalFileContent);
        System.out.println();

        writer.print(finalFileContent);
        writer.close();

        System.out.println("File " + completeFileName + " successfully created");
    }



}
