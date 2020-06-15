package space.banka.alyona.vigo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class FileRecordReader implements RecordReader {

    private static final int CELL_INDEX_YEAR = 2;
    private static final int CELL_INDEX_QUANTITY = 3;

    private final Path fileName;

    public FileRecordReader(Path fileName) {
        this.fileName = fileName;
    }

    @Override
    public Iterable<Record> readRecords() throws RecordReadingException {
        final List<String> lines;
        try {
            lines = Files.readAllLines(fileName);
            ArrayList<Record> records = new ArrayList<>();
            for (String line : lines) {
                String[] cells = line.split(" ");
                final Year year = Year.parse(cells[CELL_INDEX_YEAR]);
                final int quantity = Integer.parseInt(cells[CELL_INDEX_QUANTITY]);
                Record record = new Record(year, quantity);
                records.add(record);
            }
            return records;
        } catch (IOException | NumberFormatException | DateTimeParseException e) {
            throw new RecordReadingException(e);
        }
    }

}
