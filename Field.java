public class Field {
    private String[][] field;
    
    public Field() {
	field = new String[15][15];
    }

    public Field(int x, int y) {
	field = new String[x][y]; 
    }

    public static void main(String[] args) {
	File file = new File("Field1.txt");
	
	try {
	    Scanner sc = new Scanner(File);
	    while (sc.hasNextLine()) {
		String s = sc.next();
				
	    }
	    
	}
    }

}