import java.io.*;
import java.util.*;


public class StartAnagramsprogram{
   public static void main(String args[]){
      String filename =https://ikamva.uwc.ac.za/access/content/attachment/79485e9f-c928-4de4-a7c9-f77365f13fbc/Assignments/8e13757b-d0aa-444c-9223-2f081d572da9/joyce1922_ulysses.text ;
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
