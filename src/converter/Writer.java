package converter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

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
    public void writeClass() {
        // Signature de classe {
        finalFileContent.append("class " + className + " {\n")
        // private :
        // Méthodes et attributs privés


        // public:
        // Méthodes et attributs publics


        //append };
                .append("};\n")
                .append("\n");
    }

    public void writeFile() throws FileNotFoundException, UnsupportedEncodingException {
        String completeFileName = className + ".hpp";
        PrintWriter writer = new PrintWriter(completeFileName, "UTF-8");

        // Writing guardians, dependancies and class informations
        String guardianName = className.toUpperCase() + "_" + "HPP";
        finalFileContent.append("#ifndef " + guardianName + "\n")
                        .append("#define " + guardianName + "\n")
                        .append("\n");

        writeClass();

        finalFileContent.append("#endif\n");

        System.out.print(finalFileContent);
        System.out.println();

        writer.print(finalFileContent);
        writer.close();

        System.out.println("File " + completeFileName + " successfully created");
    }



}
