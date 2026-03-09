import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util;


public class StartAnagramsprogram{
   public static void main(String args[]){
      String filename = ;
      Map<String, List<String>> anagrams = readWords (filename);
      printAnagramGroups(anagrams);
   }
   public static Map<String, List<String>> readWords (String path) {
      Map<String, List<String>>map = new HashMap <> ();

      try (BufferedReader reader = new BufferedReader (new FileReader(path))) {
         String line;

         while ((line = reader.readline()) != null){
            String [] tokens = line.split ("\\s+");
            for (String word : tokens) {
               word = CleanWord(word);

               if (!word.isEmpty()) {
                  String key = generateKey(word);

                  if( !map.containKey(key)) {
                     map.put(key, new ArrayList<>());
                  }
                  map.get(key).add(word);
               }
            }
         }
      } catch (IOException e) {
                                                                                                                   
