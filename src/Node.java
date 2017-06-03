
public class Node {
	char letter;
	int freq;
	double freq2;
	public Node right;
	public Node left;
	public Node parent;
	Node next;
	
	public Node(char letter, double freq2){
		this.freq2 = freq2;
		this.letter = letter;
	}
	
	public Node(char letter, int freq){
		this.letter = letter;
		this.freq = freq;
	}
	
	public Node(char letter, int freq, Node left, Node right){
		this.letter = letter;
		this.freq = freq;
		this.left = left;
		this.right= right;
		
	}
	
	public Node(char letter, double freq2, Node left, Node right){
		this.letter = letter;
		this.freq2 = freq2;
		this.left = left;
		this.right= right;
		
	}
	
	public Node(Node parent){
		this.parent = parent;
	}
	
	public Node(int freq){
		this.freq = freq;
	}
	
	public void setFreq2(double freq2){
		this.freq2 = freq2;
	}
	
	public double getFreq2(){
		return freq2;
	}
	
	public void setLetter(char letter){
		this.letter = letter;
	}
	
	public char getLetter(){
		return letter;
	}
	
	public void setFreq(int freq){
		this.freq = freq;
	}
	
	public int getFreq(){
		return freq;
	}
	
	public Node getRight(){
		return right;
	}
	
	public void setRight(Node right){
		this.right = right;
	}
	
	public Node getLeft(){
		return right;
	}
	
	public void setLeft(Node left){
		this.left = left;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
	public Node getNext(){
		return next;
	}
	
	public String tostring(){
		return letter + " " + freq;
	}
	
	public boolean isLeaf(Node node){
		if (node.left == null && node.right == null){
			return true;
		}
		
		else{
			return false;
		}
	}
}
