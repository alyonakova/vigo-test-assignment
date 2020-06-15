package space.banka.alyona.vigo;

public class YearStatistic {

    private final int linesCount;
    private final int sumQuantities;

    public YearStatistic(int linesCount, int sumQuantities) {
        this.linesCount = linesCount;
        this.sumQuantities = sumQuantities;
    }

    public double getAverageQuantity() {
        return (this.sumQuantities > 0) ? ((double) this.sumQuantities / (double) this.linesCount) : 0;
    }
}
