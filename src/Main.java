import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите текст на русском языке для его дальнейшей зашифровки --->");
        Scanner scan = new Scanner(System.in);
        String src = scan.nextLine();
        System.out.println(src);

        try {
            FileOutputStream fos = new FileOutputStream("encrypt");
            fos.write(src.getBytes(StandardCharsets.UTF_8));

            Encoder.encryption();
            Decoder.decryption();
            BruteForce.bruteForce();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
















