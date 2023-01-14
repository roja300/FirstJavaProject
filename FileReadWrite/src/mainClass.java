import java.util.*;
import java.io.FileWriter;
import java.io.FileReader;

public class mainClass {
	public static String fileString = "empty";
	public static int ch;
	public static FileWriter fileWriter;
	public static FileReader fileReader;
	public static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.println("Input file path: ");
		fileString = scanner.nextLine();
		
		while (true) {
			System.out.println("Would you like to read or write? ");
			String optionForAppendingFile = scanner.nextLine();
			
			if (optionForAppendingFile.equals("read")) {
				System.out.println(ReadFileData());
			}
			
			else if (optionForAppendingFile.equals("write")) {
				System.out.println("Write string for file... ");
				String fileWriteString = scanner.nextLine();
				WriteToFile(fileWriteString);
			}
			
			else {
				System.out.println("INVALID SELECTION");
			}
		}
	}
	
	public static void WriteToFile(String stringForFile) {
		try {
			fileWriter = new FileWriter(fileString);
			fileWriter.write(stringForFile);
			fileWriter.close();
		}
		
		catch (Exception e) {
			System.out.println("FAILED TO WRITE TO FILE");
		}
	}

	
	public static String ReadFileData() {
		String fileData = "";
		try {
			fileReader = new FileReader(fileString);
			while ((ch=fileReader.read())!=-1) {
	            fileData = fileData + ((char)ch);
			}
			return fileData;
		}
		catch (Exception e) {
			System.out.println("COULD NOT READ FILE");
			return "[empty]";
		}
	}
	
}