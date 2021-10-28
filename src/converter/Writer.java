package converter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

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
        // Signature de classe {
        finalFileContent.append("class " + className + " {\n");
        // private :
        //finalFileContent.append("private :\n");

        List<Map<String,String>> listFieldInfos = fetcher.getAllFieldsInfos();
        for (Map<String,String> fieldInfos : listFieldInfos) {
            finalFileContent.append("\t" + fieldInfos.get("type") + " " + fieldInfos.get("name") + ";")
                            .append("\n");
        }

        List<Map<String,String>> listConstructorInfos = fetcher.getAllConstructorsInfos();
        for (Map<String,String> constructorInfos : listConstructorInfos) {
            finalFileContent.append("\t" + constructorInfos.get("name") + "(" + constructorInfos.get("arguments") + ");")
                    .append("\n");
        }

        List<Map<String,String>> listMethodInfos = fetcher.getAllMethodsInfos();
        for (Map<String,String> methodInfos : listMethodInfos) {
            finalFileContent.append("\t" + methodInfos.get("return_type") + " " + methodInfos.get("name") + "(" + methodInfos.get("arguments") + ");")
                    .append("\n");
        }
        // public:
        //finalFileContent.append("public :\n");

        //append };
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
