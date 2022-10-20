import java.io.IOException;

public class Reverse {
    public Reverse() {
    }

    public static String[] mySplit(String str) {
        str = str + " ";
        int cnt = 0;
        String temp = "";

        for(int i = 0; i < str.length(); ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                temp = temp + str.charAt(i);
            } else if (!temp.isEmpty()) {
                ++cnt;
                temp = "";
            }
        }

        String[] res = new String[cnt];
        int k = 0;

        for(int i = 0; i < str.length(); ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                temp = temp + str.charAt(i);
            } else if (!temp.isEmpty()) {
                res[k] = temp;
                ++k;
                temp = "";
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        MyScanner scanner = new MyScanner(System.in);
        String[] mass = new String[10];

        int k;
        for(k = 0; scanner.hasInput(); ++k) {
            String str = scanner.readString();
            if (k == mass.length) {
                String[] newMass = new String[k * 2];

                for(int i = 0; i < mass.length; ++i) {
                    newMass[i] = mass[i];
                }

                mass = newMass;
            }

            mass[k] = str;
        }

        for(int i = k - 2; i >= 0; --i) {
            String str = mass[i];
            if (str.isEmpty()) {
                System.out.println(str);
            } else {
                String[] split = mySplit(str);

                for(int j = split.length - 1; j >= 0; --j) {
                    if (!split[j].isEmpty()) {
                        System.out.print(split[j]);
                        if (j != 0) {
                            System.out.print(" ");
                        }
                    }
                }

                System.out.println();
            }
        }

    }
}