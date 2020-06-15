package space.banka.alyona.vigo;

public interface RecordReader {

    Iterable<Record> readRecords() throws RecordReadingException;
}
