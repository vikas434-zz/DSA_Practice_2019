package General;

import java.util.*;

public class HashSetIntegerList {

    public static void main(String[] args) {
        Set<List<Integer>> set = new HashSet<>();

        set.add(Arrays.asList(1,2));
        set.add(Arrays.asList(2,1));

        set.forEach(s->{
            System.out.println("s is"+s);
        });
    }
}
