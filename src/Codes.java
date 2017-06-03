
public class Codes {
	String string;
	char letter;
	
	public Codes(char letter, String string){
		this.letter = letter;
		this.string = string;
	}
	
	public void setLetter(char letter){
		this.letter = letter;
	}
	
	public char getLetter(){
		return letter;
	}
	
	public void setString(String string){
		this.string = string;
	}
	
	public String getString(){
		return string;
	}
}
