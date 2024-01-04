public class Main {
    public static void main(String[] args) {
        System.out.println("First program");
        System.out.println("Second line");

        variables();
    }

    public static void variables() {
        byte w = 123;
        int x = 123;
        long y = 1623871623123L;
        float z = 123.434f;
        double a = 12.1293109273901d;
        boolean b = true;
        char c = '@';
        String d = "bruh";

        System.out.println("My (byte) number is: " + w);
        System.out.println("My (int) number is: " + x);
        System.out.println("My (long) number is: " + y);
        System.out.println("My (float) number is: " + z);
        System.out.println("My (double) number is: " + a);
        System.out.println("My (boolean) value is: " + b);
        System.out.println("My (char) value is: " + c);
        System.out.println("My (String) value is: " + d);

    }
}
