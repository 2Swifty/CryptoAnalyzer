import groovy.lang.MetaClassImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BruteForce {
    public static void bruteForce(){
      try (FileInputStream fis = new FileInputStream("decrypt");
        InputStreamReader fileReader = new InputStreamReader(fis);
          ) {
          ArrayList<String> arrayList = new ArrayList<>();
          ArrayList<String> arrayList2 = new ArrayList<>();

          Alphabet.fillingWithSymbols(arrayList);

          while (fileReader.ready()){
              int b = fileReader.read();
              String ch = Character.toString(b);
              arrayList2.add(ch);
          }
          for (int key = 0; key < 10; key++) {
              System.out.print(" Расшифруем с помощью ключа --->   " + key + "   ");
              for (int i = 0; i < arrayList2.size(); i++) {
                  String f = arrayList2.get(i);
                  for (int j = 0; j < arrayList.size(); j++) {
                      if(f.equals(arrayList.get(j))){
                          String result = arrayList.get(j - key);
                          System.out.print(result);
                      }
                  }
              }
          }
      } catch (IOException e){
          e.printStackTrace();
      } catch (IndexOutOfBoundsException exception){
          System.out.println("  <--- конец ");
      }
    }

}
