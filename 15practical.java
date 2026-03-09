import java.io.*;
import java.util.*;


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
         System.out.println("Error reading file");
      }
      return map;
   }
   public static String cleanWord(String word){
      word = word.replaceAll ("[^a-zA-Z]", "");
      return word.toLowerCase();
   }
   public static void generateKey (String word) {
      char [] letters = word.toCharArray();
      Array.sort(letters);
      return new String(letters);
   }
   public static void printAnagramGroups (Map<String, List<String>> map){
      for (List<String> group : map.values ()){
         if (group.size() >1){
            System.out.println(group);
         }
      }
   }
}
// I acknowedge the use of the generative Ai ChatGPT to assist me in understanding what the practical needs me to do, helping me debug the program, Reminding me how i can implement a file reading program. And assisting me in understanding Hashmapping.                                                                                                                   
