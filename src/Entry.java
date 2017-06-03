
public class Entry {
	char letter;
	int freq;
	double freq2;
	
	public Entry(char letter, double freq2){
		this.freq2 = freq2;
		this.letter = letter;
	}
	
	public Entry(char letter, int freq){
		this.letter = letter;
		this.freq = freq;
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
}
