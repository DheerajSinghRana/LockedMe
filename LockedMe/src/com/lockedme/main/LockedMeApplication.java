package com.lockedme.main;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

	public class LockedMeApplication {

		public static void main(String[] args) {
			try {
				System.out.println("Welcome to LockedMe.com");
				System.out.println("Developer: Dheeraj Singh Rana\n");
				String path;
				Scanner obj;
				
				do {
					System.out.println(
							"=======MAIN MENU======= \n1) List files.\n2) Add a file.  \n3) Delete a existing file.\n4) Search a file.\n5) Exit.");
					obj = new Scanner(System.in);

					path = obj.nextLine();
					
					switch(Integer.parseInt(path)){
					case 1:
						listFiles();
						break;
					case 2:
						addAFile();
						break;
					case 3:
						deleteAFile();
						break;
					case 4:
						searchAFile();
						break;
					case 5:
						System.out.println("Exiting the app....");
						break;
					default:
						System.out.println("You have choosen incorrect option Chooes b/w 1 to 5");
					}
									
					System.out.println("\n\n");
					
				} while (!path.equals("5"));

				System.out.println("Thanks for using.");
				obj.close();
			} catch (Exception ex) {
				System.out.println("Some error occured");
			}
			

		}

		private static void searchAFile() {
			System.out.println("=======SEARCH A FILE=======");
			boolean pathnames;
			Scanner obj = new Scanner(System.in);
			String nameOfAFile;
			System.out.println("Please enter File name you want to search:");
			nameOfAFile = obj.nextLine();

			String directoryName = "C:\\companyLockerFiles\\";  

			File directory = new File(String.valueOf(directoryName));

			if (!directory.exists()) {
			       directory.mkdir();
			}
			File f = new File(directoryName + nameOfAFile);

			if (f.exists()) {
				System.out.println(nameOfAFile + " Found");
			} else {
				System.out.println("File not found!!!!");
			}

		}

		private static void deleteAFile() {
			System.out.println("=======Delete A File=======");

			Scanner obj = new Scanner(System.in);
			String nameOfAFile;
			System.out.println("Please enter File name you want to delete:");
			nameOfAFile = obj.nextLine();
			File file = new File("C:\\companyLockerFiles\\" + nameOfAFile);

			if (file.delete()) {
				System.out.println("File deleted successfully");
			} else {
				System.out.println("Failed to delete the file");
			}
		}

		private static void listFiles() {
			System.out.println("=======FILE LIST=======");
			String directoryName = "C:\\companyLockerFiles\\";  
			File directory = new File(String.valueOf(directoryName));

			if (directory.exists()) {
			      
			

			List<String> fileLists = Arrays.asList(directory.list());
			Collections.sort(fileLists);

			for (String pathname : fileLists) {
				System.out.println(pathname);
			}
			} else {
				System.out.println("No files found!");
			}

		}

		private static void addAFile() throws IOException {
			Scanner obj = new Scanner(System.in);
			String path;
			System.out.println("Enter file name with path:");
			path = obj.nextLine();
			FileInputStream fis = null;
			FileOutputStream fos = null;

			try {

				fis = new FileInputStream(path);

				String[] filenames = path.split("\\\\");
				
				String fileName = filenames[filenames.length - 1];  
				             
				String directoryName = "C:\\companyLockerFiles\\";  

				File directory = new File(String.valueOf(directoryName));

				if (!directory.exists()) {
				        directory.mkdir();
				}
				
				fos = new FileOutputStream(directoryName + fileName);

				int c;

				while ((c = fis.read()) != -1) {

					fos.write(c);
				}

				System.out.println("File Uploaded successfully!!!!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			}

		}

	}