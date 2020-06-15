package space.banka.alyona.vigo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyApp implements DataConnection {
    public static class MyAppFactory {
        public static MyApp create(String y) {
            return new MyApp(y);
        }
    }

    public MyApp(String y) {
        this.y = y;
    }

    private String y;
    private static int COUNT = 0;
    private static int COUNT1 = 0;
    protected static int startYear = 1990;
    protected static int endYear = 2020;

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.println("app v.1.13");
            for (int i = startYear; i < endYear; i++) {
                int sum = 0;
                COUNT = 0;
                COUNT1 = 0;
                String y = i + "";
                sum = new MyAppFactory().create(y).loadDatas(sum);
                double qq = sum > 0 ? (double) sum / (double) COUNT : 0;
                if (qq > 0) {
                    System.out.println(i + " " + qq);
                }
                new /*new*/ MyAppFactory().create(y).saveData(i, (int) qq);
            }
            System.out.println("gotovo");
        } catch (Exception e) {
            System.out.println("oshibka!");
        }
    }

    public int loadDatas(int sum) throws Exception {
        File file = new File("1.txt");
        //try {
        //FileOutputStream fis = new FileOutputStream(file);
        FileInputStream fis = new FileInputStream(file);
        String s = "";
        int i = fis.read();
        do {
            s = s + new String(new byte[]{(byte) i});
            i = fis.read();
        } while (i != -1);
        int begin = 0;
        while (true) {
            int e = s.indexOf("\n", begin + 1);
            if (e == -1) {
                break;
            }
            String ss = s.substring(begin, e);
            //System.out.println(ss);
            String[] sss = ss.split(" ");
            for (String string : sss) {
                //System.out.println(string);
            }
            if (sss[2].contains(this.y) || sss[2].contains(y)) {
                sum = sum + Integer.parseInt(sss[3]);
            }
            COUNT++;
            begin = e;
        }
        return sum;
    }

    public void saveData(int year, int qq) throws IOException {
        FileOutputStream fis = new FileOutputStream(new File("statistika.txt"), true);
        String s = new String();
        s = COUNT1 + " " + year + " " + qq + "\n";
        fis.write(s.getBytes());
        COUNT1++;
    }
}