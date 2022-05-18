import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Decoder {
    public static void decryption(){
        try (
                FileInputStream fis = new FileInputStream("decrypt");
                InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        ){
            ArrayList<String> arrayList = new ArrayList<>();
            Alphabet.fillingWithSymbols(arrayList);
            System.out.println();
            System.out.println("Расшифруем текст ---> ");

            while (isr.ready()){
                int b = isr.read();
                String str = Character.toString(b);
                for (int i = 0; i < arrayList.size(); i++) {
                    if (str.equals(arrayList.get(i))){
                        str = arrayList.get(i - 3);
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

