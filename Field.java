import java.util.*;
import java.io.*;
public class Field {
    private String[][] field;
    
    public Field() {
	field = new String[17][26];
    }

    public Field(int x, int y) {
	field = new String[x][y]; 
    }

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

    public static void main(String[] args) {
	File file = new File("Field1.txt");
	Field foo = new Field();
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
    }

}