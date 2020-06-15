package space.banka.alyona.vigo;

import java.io.IOException;

interface DataConnection {
    int loadDatas(int sum) throws Exception;

    void saveData(int year, int qq) throws IOException;
}
