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
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < field.length; i++) {
	    for (int j = 0; j < field[i].length; j++) {
		//adds every character
		builder.append(field[i][j]);
	    }
	    //adds new line
	    builder.append("\n");
	    System.out.println(builder);
	}
	return builder.toString();
    }

    public static void main(String[] args) {
	File file = new File("Field1.txt");
	Field foo = new Field();
	int a = 0;
	try {
	    
	    Scanner sc = new Scanner(file);
	    while (sc.hasNext()) {
		String s = sc.next();		
		//System.out.println(s + "current row");
		for (int i = 0; i < foo.field.length; i++) {
		    int k = 0;
		    for (int j = 0; j < foo.field[i].length; j++){
			String temp = s.substring(k,k+1);
			//System.out.println(temp);
			foo.field[i][j] = temp;
			k++;
		    }
		}
	    }
	    
	}
	catch (Exception e) {

	}
	foo.toString();
	//System.out.println(foo);
    }

}