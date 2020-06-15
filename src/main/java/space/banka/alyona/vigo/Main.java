package space.banka.alyona.vigo;

import java.nio.file.Path;
import java.time.Year;

public class Main {

    private static final String APP_VERSION = "1.13";

    private static final Year START_YEAR = Year.of(1990);
    private static final Year END_YEAR = Year.of(2020);

    private static final String INPUT_FILE_NAME = "1.txt";
    private static final String OUTPUT_FILE_NAME = "statistika.txt";

    public static void main(String[] args) {
        System.out.println("app v." + APP_VERSION);
        try {
            FileRecordReader fileRecordReader = new FileRecordReader(Path.of(INPUT_FILE_NAME));
            ReportGenerator reportGenerator = new ReportGenerator();
            final Report report = reportGenerator.generateReport(fileRecordReader, START_YEAR, END_YEAR);
            FileReportWriter fileReportWriter = new FileReportWriter(Path.of(OUTPUT_FILE_NAME));
            fileReportWriter.writeReport(report);
            System.err.println("Completed successfully.");
        } catch (RecordReadingException e) {
            System.err.println("Cannot read records from file: " + e);
        } catch (ReportWritingException e) {
            System.err.println("Cannot write report to file: " + e);
        }
    }
}
