package _20180926;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String, String> map = new HashMap<String, String>();
        map.put("szh", "lcx");
        map.put("zzk", "py");
        map.put("dp", "pp");

        method1(map);

        //method2(map);
    }

    private static void method2(Map<String, String> map) {
        Set<String> set = map.keySet();

        System.out.println(set);

        for (String string : set) {
            System.out.println("zf:" + string + " qz:" + map.get(string));
        }
    }

    private static void method1(Map<String, String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println("zf:" + entry.getKey() + "   xf:" + entry.getValue());
        }

        System.out.println();

        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            String zf = iterator.next().getKey();
            System.out.println("zf:" + zf + "   xf:" + map.get(zf));
        }
    }

}
