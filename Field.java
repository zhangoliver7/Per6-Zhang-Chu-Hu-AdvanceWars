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
	StringBuilder builder = new StringBuilder();
	for (int i = 0; i < field.length; i++) {
	    for (int j = 0; j < field[i].length; i++) {

	    }
	}
    }

    public static void main(String[] args) {
	File file = new File("Field1.txt");
	Field foo = new Field();
	try {
	    Scanner sc = new Scanner(file);
	    while (sc.hasNextLine()) {
		String s = sc.next();		
		for (int i = 0; i < foo.field.length; i++) {
		    for (int j = 0; j < foo.field[i].length; j++){
			foo.field[i][j] = s;
		    }
		}
	    }
	    
	}
	catch (Exception e) {

	}
	System.out.println(Arrays.toString(foo.field));
    }

}