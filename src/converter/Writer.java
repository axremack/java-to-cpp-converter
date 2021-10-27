package converter;

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




}
