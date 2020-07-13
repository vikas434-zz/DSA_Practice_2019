package General;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vranjan on 2020-07-14
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int [] arr = {1, 3, 4};
        
        for(int i : arr) {
            System.out.println("Map is "+map.get(i));
        }
    }
}
