package space.banka.alyona.vigo;

import java.time.Year;
import java.util.*;

public class ReportGenerator {

    public Report generateReport(RecordReader recordReader, Year startYear, Year endYear) throws RecordReadingException {
        if (!(startYear.isBefore(endYear))) {
            throw new IllegalArgumentException("startYear must be less than endYear");
        }
        Map<Year, List<Record>> recordsByYear = new HashMap<>();
        for (Record record : recordReader.readRecords()) {
            final List<Record> recordsForYear = recordsByYear.computeIfAbsent(record.getYear(), y -> new ArrayList<>());
            recordsForYear.add(record);
        }

        Map<Year, YearStatistic> yearStatisticsMap = new HashMap<>();
        int recordsCount = recordsByYear.values().stream().mapToInt(List::size).sum();
        for (Year year = startYear; year.isBefore(endYear); year = year.plusYears(1)) {
            final List<Record> recordsForYear = recordsByYear.getOrDefault(year, Collections.emptyList());
            int quantitySum = recordsForYear.stream().mapToInt(Record::getQuantity).sum();
            yearStatisticsMap.put(year, new YearStatistic(recordsCount, quantitySum));
        }
        return new Report(yearStatisticsMap);
    }
}
