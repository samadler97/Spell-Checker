import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
	
		//This tree will hold all of the words passed from the file
		BinarySearchTree dictionaryTree = new BinarySearchTree();

		//Check if a file has been entered
		if (args.length == 0) {
			System.out.println("No file entered.");
		}

		else {
			File inputFile = new File(args[0]);
			//Read in the input file and insert all of the words
			//into dictionaryTree
			try {
				BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				String inputLine = "";
				while((inputLine = reader.readLine()) != null) {
					dictionaryTree.insert(inputLine);
				}
			}

			catch (IOException e) {
				System.out.println("File cannot be opened.");
				System.exit(0);
			}
		
			//Print out the height of the tree
			System.out.println("Loaded the words into a tree with height = " + dictionaryTree.height(dictionaryTree.getRoot()));
		
			//Gets a word or phrase from the user to check
			Scanner input = new Scanner(System.in);
			String[] wordOrPhrase = input.nextLine().split(" ");

			//Checks every word in the input array for correct spelling until
			//user ends the program
			while(!(wordOrPhrase[0].equals("END"))) {
				for(int i = 0; i < wordOrPhrase.length; i++) {
					if(dictionaryTree.search(wordOrPhrase[i]) == null) {
						System.out.println(wordOrPhrase[i] + " is spelled wrong!");
					}
				}

				wordOrPhrase = input.nextLine().split(" ");
			}
		}
	}
}
