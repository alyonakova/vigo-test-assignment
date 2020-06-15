package space.banka.alyona.vigo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.List;

public class FileReportWriter implements ReportWriter {

    private final Path fileName;

    public FileReportWriter(Path fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeReport(Report report) throws ReportWritingException {
        try {
            final BufferedWriter writer = Files.newBufferedWriter(fileName);
            List<Year> years = report.getYears();
            for (int yearIndex = 0; yearIndex < years.size(); yearIndex++) {
                Year year = years.get(yearIndex);
                final YearStatistic statisticForYear = report.getStatisticForYear(year);
                final String reportLine = String.format("%d %s %s\n", yearIndex, year, statisticForYear.getAverageQuantity());
                writer.write(reportLine);
            }
        } catch (IOException e) {
            throw new ReportWritingException(e);
        }
    }
}
