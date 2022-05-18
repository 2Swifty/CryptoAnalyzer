import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Encoder {
    public static void encryption(){
        try (
                FileInputStream fis = new FileInputStream("encrypt");
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
                FileOutputStream fos = new FileOutputStream("decrypt")
        ){
            ArrayList<String> arrayList = new ArrayList<>();
            Alphabet.fillingWithSymbols(arrayList);
            System.out.println("Зашифруем текст ---> ");

            while (isr.ready()){
                int b = isr.read();
                String str = Character.toString(b);
                for (int i = 0; i < arrayList.size(); i++) {
                    if (str.equals(arrayList.get(i))){
                        str = arrayList.get(i + 3);
                        fos.write(str.getBytes(StandardCharsets.UTF_8));
                        System.out.print(str);
                        break;
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}






















































































































    /* public static String encrypt(String str,int keyLength) {
        String encrypted = "";
        for (int i = 0; i < str.length(); i++) {

            int c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                c = c + (keyLength % 26);

                if (c > 'Z')
                    c = c - 26;
            } else if (Character.isLowerCase(c)) {
                c = c + (keyLength % 26);

                if (c > 'z')
                    c = c - 26;
            }

            encrypted = encrypted + (char) c;
        }
        return encrypted;
    }
*/




