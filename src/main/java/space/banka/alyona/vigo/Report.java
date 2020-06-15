package space.banka.alyona.vigo;

import java.time.Year;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Report {

    private final Map<Year, YearStatistic> statisticsByYear;

    public Report(Map<Year, YearStatistic> yearStatisticsMap) {
        this.statisticsByYear = yearStatisticsMap;
    }

    public List<Year> getYears() {
        final List<Year> years = new java.util.ArrayList<>(statisticsByYear.keySet());
        Collections.sort(years);
        return years;
    }

    public YearStatistic getStatisticForYear(Year year) {
        return statisticsByYear.get(year);
    }
}
