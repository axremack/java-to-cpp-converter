package converter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Writer {
    private Fetcher fetcher;
    private String finalFileName;
    private StringBuilder finalFileContent;

    // Constructor
    public Writer(Fetcher fetcher, String finalFileName, StringBuilder finalFileContent) {
        this.fetcher = fetcher;
        this.finalFileName = finalFileName;
        this.finalFileContent = finalFileContent;
    }

    // Getters and setters
    public Fetcher getFetcher() { return fetcher; }

    public void setFetcher(Fetcher fetcher) { this.fetcher = fetcher; }

    public String getFinalFileName() { return finalFileName; }

    public void setFinalFileName(String finalFileName) { this.finalFileName = finalFileName; }

    public StringBuilder getFinalFileContent() { return finalFileContent; }

    public void setFinalFileContent(StringBuilder finalFileContent) { this.finalFileContent = finalFileContent; }

    // Methods
    public void writeGuardians() {
        String guardianName = finalFileName.toUpperCase() + "_" + "HPP";
        finalFileContent.append("#ifndef " + guardianName + "\n")
                        .append("#define " + guardianName + "\n")
                        .append("#endif\n");
    }




    public void writeFile() throws FileNotFoundException, UnsupportedEncodingException {
        String completeFileName = finalFileName + ".hpp";
        PrintWriter writer = new PrintWriter(completeFileName, "UTF-8");

        // Writing guardians, dependancies and structure
        writeGuardians();

        System.out.print(finalFileContent);
        System.out.println();

        writer.print(finalFileContent);
        writer.close();

        System.out.println("File " + completeFileName + " successfully created");
    }



}
