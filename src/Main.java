import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        fileWritterExample();
        fileReaderExample();
    }

    public static void fileWritterExample() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("example.txt"))) {

            writer.write("\n1 Buffered writing is faster.\n");
            writer.write("2 This is another line.\n");
            writer.flush();
            char[] data = {'H', 'e', 'l', 'l', 'o', '!', '\n'};
            writer.write(data);
            writer.write(data, 0, 5);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileReaderExample() {
        try (FileReader reader = new FileReader("example.txt")) {

            char[] buffer = new char[1];
            int length;
            while ((length = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, length));
            }

            int data;
            while ((data = reader.read()) != -1) {
                if (Character.isLetter(data)) { // Фильтруем только буквы
                    System.out.print((char) data);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}