package _20180929;

import java.io.FileWriter;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("d:\\cb.txt");
        fileWriter.write("����˯��������");
        fileWriter.flush();
        //while(true) {}
    }
}
