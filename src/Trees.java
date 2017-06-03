import java.util.*;
import java.io.*;

public class Trees{
	static Node root = null;
	static Node node = null;
	static Node head = null;
	static Node parent;
	static Node leftChild;
	static Node rightChild;
	static Node rootB = null;
	static Node nodeB = null;
	static Node headB = null;
	static Node current;
	static Node parentB;
	static Node leftChildB;
	static Node rightChildB;
	static String message = null;
	static Scanner input = new Scanner(System.in);
	static Scanner input2 = new Scanner(System.in);
	static int numLetters = 0;
	static int size =0;
	static Entry[] entry;
	static int n= -1;
	static Codes[] codes;
	static Codes[] codesB;
	static String[] codesArray;
	static int freq;
	static int num = -1;
	
	public static void main(String[] args){
		
		char ch;
		char choice, choice2;
		
		do{
			System.out.println();
			System.out.println("Choose Mode");
			System.out.println("[A] String");
			System.out.println("[B] Statistical Distribution");
			System.out.println("[C] Exit");
			System.out.println("Choice: ");
			choice = input2.next().charAt(0);
			
			if (choice == 'A' || choice == 'a'){
				
				do{
					System.out.println("[a] Enter a new String");
					System.out.println("[b] Return to the main menu");
					System.out.println("Choice: ");
					choice2 = input2.next().charAt(0);
					
					if (choice2 == 'A' || choice2 == 'a'){
						message = null;
						root = null;
						node = null;
						head = null;
						parent = null;
						rightChild = null;
						leftChild = null;
						entry = null;
						n = -1;
						codes = null;
						codesArray = null;
						
						System.out.println("Enter message: ");
						message = input.nextLine();
						message = message.toLowerCase();
						
						for (char i = ' ' ; i<= 'z'; i++){
							freq = 0;
							for (int j = 0; j<message.length(); j++){
								ch=message.charAt(j);
								if (ch == i){
									freq++;
								}
							}
							if (freq!=0){
								numLetters++;
							}
						}
						
						entry = new Entry[numLetters];
						
						numLetters = 0;
						
						for (char i = ' ' ; i<= 'z'; i++){
							freq = 0;
							for (int j = 0; j<message.length(); j++){
								ch=message.charAt(j);
								if (ch == i){
									freq++;
								}
							}
							if (freq!=0){
								entry[numLetters] = new Entry(i, freq);
								numLetters++;
							}
						}
						
						int temp = 0;
						char tempchar = '\0';
						
					    for(int i=0; i < numLetters; i++){  
					       for(int j=1; j < (numLetters-i); j++){  
					          if(entry[j-1].freq> entry[j].freq){  
					              //swap elements  
					              temp = entry[j-1].freq;
					              tempchar = entry[j-1].letter;
					              entry[j-1].freq = entry[j].freq;  
					              entry[j-1].letter = entry[j].letter;
					              entry[j].freq = temp;  
					              entry[j].letter = tempchar;
					          }  
					       }  
					    }  
					    
					    //System.out.println("Unique Characters with their frequencies...");
					    
					    for (int i = 0; i<numLetters; i++ ){
					    	node = new Node(entry[i].letter, entry[i].freq);
					    	//System.out.println( "\t" +entry[i].letter +"  " + entry[i].freq);
					    	addNodes(node);
					    }
					    	
					    constructTree();
					    
						codes = new Codes[numLetters]; 
						
					    visitNode(root, "");
					    
					    printCodes();
					    
					    decode();
					    System.out.println();
					}
					
					else if(choice2 == 'B' || choice2 == 'b'){
						break;
					}
					
					else{
						System.out.println("Sorry you entered a wrong keyword...");
					}
					
				}while(choice2 != 'B' || choice2 != 'b');
				
			}
			
			else if (choice == 'B' || choice == 'b'){
				
				do{
					message = null;
					root = null;
					node = null;
					head = null;
					parentB = null;
					rightChildB = null;
					leftChildB = null;
					codesB = null;
					num = 0;
					
					System.out.println("[a] Enter a new String");
					System.out.println("[b] Return to the main menu");
					System.out.println("Choice: ");
					choice2 = input2.next().charAt(0);
					
					if (choice2 == 'A' || choice2 == 'a'){
						head = null;
						
						System.out.println("Enter message: ");
						message = input.nextLine();
						message = message.toLowerCase();
					
						System.out.println("Message: " + message);
						readFile();
						constructTreeB();
						
						
						codesB = new Codes[num]; 
						n = 0;
						visitNodeB(root, "");
						   
						printCodesB();
						   
						decodeB();
						System.out.println();
						System.out.println();
						
					}
					
					else if(choice2 == 'B' || choice == 'b'){
						break;
					}
					
					else{
						System.out.println("Sorry you entered a wrong keyword....");
					}
				}while(choice2 != 'B' || choice2 != 'b');
				
			}
			
			else if (choice == 'C' || choice == 'c'){
				System.out.println("Thank you for using this program...");
				System.exit(0);
			}
			
			else{
				System.out.println("Sorry but you entered a wrong keyword...");
			}
		}while(choice!='C' || choice!='c');
		
	}	

	public static void readFile(){
		BufferedReader rd = null;
		
		try{
			try{
				rd = new BufferedReader(new FileReader(new File("distribution")));
				
				int c;
				double stat;
				while((c = rd.read())!=-1){
					//if (c == letter){
						num++;
						char let= (char)c;
						stat = Double.parseDouble(rd.readLine());
						//System.out.println(let +" " + stat);
						freqDist(let, stat);
						///break;
					//}
				}
			}
			
			catch(Exception ex){
				ex.printStackTrace();
			}
			finally{
				rd.close();
				
			}
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}
	
	public static void freqDist(char letter, double freq2){
		nodeB = new Node(letter, freq2);
		if (head == null){
			head = nodeB;
			current = head;
		}
		else{
			current.setNext(nodeB);
			current = current.getNext();
		}
	}
	
	public static void printCodes(){
		System.out.println("Letters with their certain codes...");
	    for(int i = 0; i< numLetters; i++){
	    	System.out.println("  Letter: " + codes[i].letter + "\tCode: " + codes[i].string);
	    }
	}
	
	public static void printCodesB(){
		System.out.println("Letters with their certain codes...");
	    for(int i = 0; i< num; i++){
	    	System.out.println("  Letter: " + codesB[i].letter + "\tCode: " + codesB[i].string);
	    }
	}
	
	public static void charFreq(){
		 System.out.println("Unique Characters with their frequencies...");
		    
		    for (int i = 0; i<numLetters; i++ ){
		    	node = new Node(entry[i].letter, entry[i].freq);
		    	System.out.println( "\t" +entry[i].letter +"  " + entry[i].freq);
		    	addNodes(node);
		    }	
	}
	
	public static void decode(){
		
		System.out.println("Your message is: " + message);
		char[] messArray = message.toCharArray();
		
		System.out.println("Huffman coded bit string is:" );
		for(int i = 0; i<message.length(); i++){
			
			for(int j = 0; j<numLetters; j++){
				if(messArray[i] == codes[j].letter){
					System.out.print(codes[j].string);
				}
			}
		}
	}
	
	public static void decodeB(){
		
		System.out.println("Your message is: " + message);
		char[] messArray = message.toCharArray();
		
		System.out.println("Huffman coded bit string is:" );
		for(int i = 0; i<message.length(); i++){
			
			for(int j = 0; j<num; j++){
				if(messArray[i] == codesB[j].letter){
					System.out.print(codesB[j].string);
				}
			}
		}
	}

	public static void visitNode(Node node, String string){
		if(node.left!=null){
			visitNode(node.left, string + "0");
		}
		
		if (node.right!=null){
			visitNode(node.right, string + "1");
		}
		
		if (node.left == null && node.right == null && n < numLetters){
			n++;
			codes[n] = new Codes(node.letter, string);
		}
	}
	
	public static void visitNodeB(Node node, String string){
		if(node.left!=null){
			visitNodeB(node.left, string + "0");
		}
		
		if (node.right!=null){
			visitNodeB(node.right, string + "1");
		}
		
		if (node.left == null && node.right == null && n < num){
			//n++;
			codesB[n++] = new Codes(node.letter, string);
		}
	}
	
	public static void addNodes(Node node){
		Node current;
		Node next;
		
		if (head == null){
			size++;
			head = node;
		}
		
		else{	
			for(current = head; (next = current.getNext()) != null; current = next);
				current.setNext(node);
			size++;
		}
	}
	
	public static void constructTree(){
		try{
			for(int i = 0; i < numLetters; i++){
				size++;
				Node parent = new Node('\0', 0, null, null);
				
				Node leftChild = removeFirst();
				parent.setLeft(leftChild);
				
				Node rightChild = removeFirst();
				parent.setRight(rightChild);
				
				parent.setFreq(rightChild.getFreq() + leftChild.getFreq());
				System.out.println();
				System.out.println("Parent: " + parent.freq);
				System.out.println("Right Child: " + rightChild.letter + " " + rightChild.freq);
				System.out.println("Left Child:  " + leftChild.letter + " " + leftChild.freq);
				sortedInsert(parent);
				
			}
		} catch(NullPointerException ex){
			
		}
	}
	
	public static void constructTreeB(){
		try{

			for(int i = 0; i < num; i++){
				Node parentB = new Node('\0', 0.0, null, null);
				
				Node leftChildB = removeFirst();
				parentB.setLeft(leftChildB);
				
				Node rightChildB = removeFirst();
				parentB.setRight(rightChildB);
				
				parentB.setFreq2(rightChildB.getFreq2() + leftChildB.getFreq2());
				System.out.println();

				System.out.println("Parent:      "+ parentB.freq2);
				System.out.println("Right Child: " + rightChildB.letter + " " + rightChildB.freq2);
				System.out.println("Left Child:  " + leftChildB.letter + " " + leftChildB.freq2);
				sortedInsertB(parentB);
				
			}
		} catch(NullPointerException ex){
			
		}
	}
	
	public static Node removeFirst(){
		Node node = head;
		if(node != null){
			head = node.getNext();
			node.setNext(null);
		}
		return node;
	}
	
	public static void sortedInsertB(Node parentB)
    {
         Node current;
 
         /* Special case for head node */
         if (head == null || head.freq2 >= parentB.freq2)
         {
            parentB.next = head;
            head = parentB;
         }
         
         else {
 
            /* Locate the node before point of insertion. */
            current = head;
 
            while (current.next != null &&
                   current.next.freq2 < parentB.freq2)
                  current = current.next;
 
            parentB.next = current.next;
            current.next = parentB;
         }
         
         root = head;
     }
	
	public static void sortedInsert(Node parent)
    {
         Node current;
 
         /* Special case for head node */
         if (head == null || head.freq >= parent.freq)
         {
            parent.next = head;
            head = parent;
         }
         
         else {
 
            /* Locate the node before point of insertion. */
            current = head;
 
            while (current.next != null &&
                   current.next.freq < parent.freq)
                  current = current.next;
 
            parent.next = current.next;
            current.next = parent;
         }
         
         root = head;
     }
}
	