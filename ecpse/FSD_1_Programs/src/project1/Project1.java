package project1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Project1 {

	public static void main(String[] args) throws IOException {
			
		
	     System.out.println("****************************************************************");
	   	 System.out.println("*********************  File Brower System  ********************");
	   	 System.out.println("*********************  By David Guo  ********************");
	   	 System.out.println("****************************************************************");
	   	 System.out.println();
	   	 
	   	 
	   	 	int choice = 0;
	   	 	
	   	 	int c2 = 0;
	   	 	
	   	 	String workDir = System.getProperty("user.dir");
	   	 	
	
			

			
		
	   	 	
	   	 fileExplorer fs = new fileExplorer(workDir);
	   	String fileName;
	   	 
			while(choice !=3 ) {
				System.out.println("Please Choose a value between 1 and 3");
				System.out.println("Choose 1 to list current file names in ascending order");
				System.out.println("Choose 2 to open the user inferface");
				System.out.println("Choose 3 to close the application");
				try {
					Scanner sc = new Scanner(System.in);
					
					choice = Integer.parseInt(sc.nextLine());
				} catch (NumberFormatException e) {

				}
				switch (choice) {
				case 1:
					System.out.println("The file names in  this directory are: ");
					fs.listFiles();

					break;
				case 2:
					
					while (c2 !=4) {
						try {
							System.out.println("Choose 1, 2, 3, or 4, respectively to add, delete, search, or go back to the main menu");
							Scanner sc1 = new Scanner(System.in);
							c2 = Integer.parseInt(sc1.nextLine());
						} catch (NumberFormatException e) {

						}
						switch (c2) {
						
						case 1:
							System.out.println("Add a file to the directory");
							Scanner sc1 = new Scanner(System.in);
							
							 fileName = sc1.nextLine();

							fs.addFile(fileName);

							break ;
						case 2:
							System.out.println("Delete a file from the directory");
							Scanner sc2 = new Scanner(System.in);
							
							 fileName = sc2.nextLine();

							fs.deleteFile(fileName);

							break;
						case 3:
							System.out.println("Search a file from the directory");
							Scanner sc3 = new Scanner(System.in);
							
							 fileName = sc3.nextLine();
							 
							 System.out.println(fileName);

							System.out.println(fs.searchFile(fileName));

							break;
						case 4:
							System.out.println("Back to the Main Menu");

							break;
						
						default:
							System.out.println("Please enter an appropriate choice");
							break;

						}
						
					}
				
				case 3:
					

					break;
				default:
					System.out.println("Please enter an appropriate choice");
					break;
				}
			} 
			System.out.println("Closing the file browser");


		
		
		}

}

class fileExplorer{
	
	String directoryName;
	FileWriter output = null;
	File file;
	File folder;

	
	public fileExplorer(String directoryName) {
		this.directoryName = directoryName;
	}
	
	public void listFiles() {
		File folder = new File(directoryName);
		File[] listFiles = folder.listFiles();
		
		String[] filenames = new String[listFiles.length];
		
		for(int i = 0; i < listFiles.length; i++) {
			filenames[i] = listFiles[i].getName();
			
			
			
			
		}
		
		Arrays.sort(filenames);;

		
		for(int i = 0; i < filenames.length; i++) {
			System.out.println(filenames[i]);
			
			
			
			
		}
		
		
		

		
	}
	
	
	public void addFile(String filename) throws IOException {
		File file = new File(directoryName + "/" + filename);
		file.createNewFile();
		System.out.println("File added successfully");
		
		
		
		
	}
	
	public void deleteFile(String filename) {
		filename = directoryName + "/" + filename;
		
		file = new File(filename);
		
		if (file.exists()) {
			if (file.delete())
				System.out.println( "File Deleted Successfully");
			else
				System.out.println("File not Deleted");
		} else {
			System.out.println("File not found");
		}
		
		
	}
	
	public String searchFile(String filename) {
		File folder = new File(directoryName);
		File[] listFiles = folder.listFiles();
		
		for(int i = 0; i < listFiles.length; i++) {
			if(filename.equals(listFiles[i].getName())){
				return "File found";
			}
			
			
			
			
		}
		return "File not found";
		
		
		
	}
	
}
