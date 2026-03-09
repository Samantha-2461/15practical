import java.io.*;
import java.util.*;

public class StartAnagramsprogram {
    public static void main(String args[]) {
        
        String filePath = "joyce1922_ulysses.txt";
        
        
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File '" + filePath + "' not found!");
            System.out.println("\nPlease upload the file to your online compiler.");
            System.out.println("Current directory contains:");
            String[] files = new File(".").list();
            if (files != null) {
                for (String f : files) {
                    System.out.println("  - " + f);
                }
            }
            return;
        }
        
        System.out.println("Reading file: " + filePath);
        Map<String, List<String>> anagrams = readWords(filePath);
        printAnagramGroups(anagrams);
    }
    
    public static Map<String, List<String>> readWords(String path) {
        Map<String, List<String>> map = new HashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int lineCount = 0;
            int wordCount = 0;
            
           
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] tokens = line.split("\\s+");
                
                for (String word : tokens) {
                    word = cleanWord(word);
                    
                    if (!word.isEmpty()) {
                        wordCount++;
                        String key = generateKey(word);
                        
                       
                        if (!map.containsKey(key)) {
                            map.put(key, new ArrayList<>());
                        }
                        
                       
                        if (!map.get(key).contains(word)) {
                            map.get(key).add(word);
                        }
                    }
                }
            }
            
            System.out.println("File processed successfully!");
            System.out.println("Lines read: " + lineCount);
            System.out.println("Words found: " + wordCount);
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file - " + e.getMessage());
        }
        
        return map;
    }
    
    public static String cleanWord(String word) {
        word = word.replaceAll("[^a-zA-Z]", "");
        return word.toLowerCase();
    }
    
    public static String generateKey(String word) {
        char[] letters = word.toCharArray();
        
        Arrays.sort(letters);
        return new String(letters);
    }
    
    public static void printAnagramGroups(Map<String, List<String>> map) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("ANAGRAM GROUPS");
        System.out.println("=".repeat(50));
        
        int groupCount = 0;
        for (List<String> group : map.values()) {
            if (group.size() > 1) {
                groupCount++;
                System.out.println(groupCount + ". " + group + " (size: " + group.size() + ")");
            }
        }
        
        if (groupCount == 0) {
            System.out.println("No anagram groups found.");
        } else {
            System.out.println("=".repeat(50));
            System.out.println("Total anagram groups: " + groupCount);
        }
    }
}
// I acknowedge the use of the generative Ai ChatGPT to assist me in understanding what the practical needs me to do, helping me debug the program, Reminding me how i can implement a file reading program. And assisting me in understanding Hashmapping.                                                                                                                   
