import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/* CSA: PROJ 04: Reminders for Running Code
 *
 * 1. Edit code in Sublime.
 * 2. Save your copy & make sure it is in the correct folder.
 * 3. Run code in Terminal:
 * - Navigate to correct directory: cd Desktop -> cd proj04CSA
 * - Compile code: javac <file name>
 * - Run code: java <class name>
 * 4. Analyze output in the Terminal. 
 * 5. Edit code & save all changes.
 *
 * Repeat steps 3-5 as needed.
 * Remember: Save each time you make changes before running it.
 */

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  
  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        //System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }
  
    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
  
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());

    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }

  // OUR WORK STARTS HERE
  public static double totalSentiment(String fileName) {
      double total = 0.0000000000;
      try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        String line;
        while ((line = br.readLine()) != null) {

            String[] words = line.split(" ");
            for (String word : words){
              if (word.length() > 0 && word.charAt(0) == '*') total += sentimentVal(word.substring(1)); 
              else total += sentimentVal(word);
            }
        }
      } catch (IOException e) {
        System.out.println("File not found.");
        System.exit(1);
      }
      return total;
  }
  public static double sentenceSentiment(String sentence) {
    String[] words = sentence.split(" ");
    int total = 0;
    for (String word : words) total += sentimentVal(word);
    System.out.println(total);
    return total;
  }

  public static int starRating(String fileName) {
  	double sentiment = totalSentiment(fileName);
  	if (sentiment < 0) return 1;
  	else if (sentiment < 5) return 2;
  	else if (sentiment < 10) return 3;
  	else if (sentiment < 15) return 4;
  	else return 5;
  }

   public static String fakeReview(String fileName){
    String originalFile = textToString(fileName);
    String fakeReview = "";

    String words[] = originalFile.split(" ");

    for (int i = 0; i < words.length; i++){
      
      if(words[i].charAt(0) == '*'){
        fakeReview += randomAdjective() + getPunctuation(words[i]) + " ";
      }
      else {
        fakeReview += words[i] + " ";
      }
    }
    return fakeReview;
  } 
  
  public static String fakeReview_v2(String fileName) {
    String originalFile = textToString(fileName);
    String fakeReview = "";
    String words[] = originalFile.split(" ");

    for (int i = 0; i < words.length; i++){
      if(words[i].charAt(0) == '*'){
        fakeReview += (totalSentiment(fileName) > 0 ? randomPositiveAdj() : randomNegativeAdj()) + getPunctuation(words[i]) + " ";
      }
      else {
        fakeReview += words[i] + " ";
      }
    }
    return fakeReview;
  }
}
