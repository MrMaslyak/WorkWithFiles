import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        fileWritterExample();
        //fileReaderExample();
        pathExample();
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
                if (Character.isLetter(data)) {
                    System.out.print((char) data);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pathExample() {
        try {
            Path path = Path.of("example.txt");
            Files.writeString(path, "Hello, Java 11!");
            String content = Files.readString(path);
            Files.copy(path, Path.of("example-copy.txt"));
            System.out.println(content);
            System.out.println(Files.size(path));
            System.out.println(Files.getLastModifiedTime(path));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}