package _20180927;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println("No.:" + entry.getKey() + " value:" + entry.getValue());
        }
    }

}
