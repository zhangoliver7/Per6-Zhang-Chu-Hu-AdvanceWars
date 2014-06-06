import java.util.*;
import java.io.*;
public class newField {
    private Terrain[][] field;
    
    public newField() {
	field = new Terrain[17][26];
    }

    public newField(int x, int y) {
	field = new Terrain[x][y]; 
    }

    public void setCoor(){
	for (int x = 0; x < field.length; x++)
	    for (int y = 0; y < field[x].length; y++){
		field[x][y].setXcor(x);
		field[x][y].setYcor(y);
	    }
    }

    /*public void moveRange(int x, int y, int move){
	
      }*/

    public String toString() {
	//builds the string
	String builder = "";
	for (int i = 0; i < field.length; i++) {
	    for (int j = 0; j < field[i].length; j++) {
		//adds every character
		builder += field[i][j];
		//System.out.println("current builder" + builder + "\n" + i + " " + j);
	    }
	    //adds new line
	    builder += "\n";
	    //System.out.println(builder);
	}
	return builder;
    }

    /*public static void main(String[] args) {
	File file = new File("Field1.txt");
	newField foo = new newField();
	int a = 0;
	try {
	    
	    Scanner sc = new Scanner(file);
	    while (sc.hasNext()) {
		String s = sc.next();		
		    int k = 0;
		    for (int j = 0; j < foo.field[a].length; j++){
			String temp = s.substring(k,k+1);
			System.out.println("temp:" + temp + "   a:" + a);
			foo.field[a][j] = temp;
			k++;
		    }
		
		a++;
	    }
	    
	}
	catch (Exception e) {

	}
	foo.toString();
	System.out.println(foo);
	}*/

}
