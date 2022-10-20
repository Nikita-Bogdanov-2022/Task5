import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        MyScanner in = new MyScanner(System.in);
        String s = in.readString();
        System.out.println(s);
    }
}
