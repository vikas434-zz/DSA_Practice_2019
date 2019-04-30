
// Find pairs which add up to a number in an array .
// if input integer array is {2, 2, 7, 5, 6, 3, 9, 7, 11} and given sum is 9, output should be {6,3} and {2,7}

// 1.hashset = {7, 4, 3,
// 2. visitedFlag[] set (2,7} {2,7}
// 3. No visited flag -> n2.
// 4. without n2 ??? one traversal hashset = {7,7,2,4,5,6,0,2,-2} X
// 5. LinkedHashMap:- LinkedHashMap<Integer, HashMap<Integer,Integer>>
//                                   2             //count of 2, //count of 7

//2, 1, 2 => 2, 7, 7
//7, 2, 1 => 7, 7, 2
// 5, 1, 0
// 6, 1, 1
// 3, 1, 1

// ArrayList => visitedKeysList(7)

//    synchronized (this) {
//
//    }

// Interface -
public class test implements myrunnable, mycomparabale {

    @Override
    public void run() {
       //  myrunnable.super.run();
        mycomparabale.super.run();
    }
}

interface myrunnable {
    default void run() {
        System.out.println("I am from runnable");
    }
}

interface mycomparabale {
    default void run() {
        System.out.println("I am from comparable");
    }
}

