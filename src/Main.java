import java.util.Date;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Date date1 = new Date(-1);
        System.out.println(date1);
        System.out.println(date1.getTime());

        Date date2 = new Date(0);
        System.out.println(date2);
        System.out.println(date2.getTime());
    }

}
