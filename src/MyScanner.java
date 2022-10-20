import java.io.*;

public class MyScanner {
    private Reader reader;
    private int currentIndex = 0;
    private int bufferSize = 0;
    private char[] buffer = new char[1024];

    /*public MyScanner(){
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }*/
    public MyScanner(InputStream is) throws IOException {
        reader = new InputStreamReader(is);
    }

    public MyScanner(String fileName) throws IOException {
        reader = new InputStreamReader(new FileInputStream(fileName));
    }

    void close() throws IOException {
        reader.close();
    }

    public boolean hasInput() throws IOException {
        if (currentIndex == bufferSize) {
            currentIndex = 0;
            bufferSize = reader.read(buffer);
        }
        return currentIndex < bufferSize;
    }

    public String readString() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        while (!Character.isWhitespace(buffer[currentIndex])/*buffer[currentIndex] != '\n' && buffer[currentIndex] != -1*/) {
            stringBuilder.appendCodePoint(nextChar());
            if (!hasInput())
                break;
        }

        return stringBuilder.toString();
    }

    public char nextChar() throws IOException {
        if (currentIndex == bufferSize) {
            currentIndex = 0;
            bufferSize = reader.read(buffer);
        }
        char c = buffer[currentIndex];
        currentIndex++;
        return c;
    }

}
