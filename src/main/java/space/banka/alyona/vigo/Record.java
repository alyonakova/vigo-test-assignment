package space.banka.alyona.vigo;

import java.time.Year;

public class Record {

    private final Year year;
    private final int quantity;

    public Record(Year year, int quantity) {
        this.year = year;
        this.quantity = quantity;
    }

    public Year getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }
}
