package test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @create 2020/8/25
 * @author hw
 */

public class CMH {

    static Map<String,String> cmh = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        cmh.put("1","2");
    }
}
