package weinberg.jason.textfileinfo;

import java.io.*;
import java.util.*;
import java.util.stream.*;

/**
 * Counts and prints the number of words, sentences, and paragraphs
 * in a text file that is provided by the user.
 * 
 * @author Jason Weinberg
 *
 */
public class App {
	
	/**
	 * Counts number of words, sentences, and paragraphs in text file
	 * and prints those counts to user's console.
	 * 
	 * @param filePath	Path of text file provided by user.
	 */
	private static void countAndPrintInfo(String filePath) {
		int wordCount = 0, sentenceCount = 0, paragraphCount = 0;
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
			String data = bufferedReader.lines().collect(Collectors.joining("\n")).trim();
			wordCount += data.split("\\w.*?\\s+").length; // Word + [Character(s)] + Space(s)
			sentenceCount += data.split("\\w.*?[.!?:]+[\'\"]*?\\s+|\\w.*?\\n+").length; // (Word + [Character(s)] + .|!|?|: + ['|"] + Space(s)) | Word + ([Character(s)] + LineBreak(s))
			paragraphCount += data.split("\\w.*?\\n{2,}").length; // Word + [Character(s)] + LineBreaks
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Number of Words: " + wordCount);
		System.out.println("Number of Sentences: " + sentenceCount);
		System.out.println("Number of Paragraphs: " + paragraphCount);
	}
	
	/**
	 * Reads file path passed as argument to application,
	 * or prompts user to specify one if argument is not passed.
	 * 
	 * @param args	Program arguments provided by user.
	 */
	public static void main(String[] args) {
		String filePath = null;
		if(args.length < 1) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter path to text file: ");
			filePath = scanner.nextLine();
			scanner.close();
		} else {
			filePath = args[0];
		}
		
		countAndPrintInfo(filePath);
	}
}
