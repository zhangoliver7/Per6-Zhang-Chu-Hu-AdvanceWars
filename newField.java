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
		field[x][y].setXcor(y);
		field[x][y].setYcor(x);
	    }
    }

    //very easy to break code if x,y not in field
    //However, I highly doubt this function will be called in such a situation.
    //pathfinding gogogogogogogogo
    public void moveRange(int x, int y, int move, Terrain prev){
	if (move > 0){
	    move -= 1;
	    field[x][y].setprevTerrain(prev);
	    field[x][y].toggleBread();
	    if (x+1 < field.length && !(field[x+1][y].getBread())){
		moveRange(x+1,y,move,field[x][y]);
	    }
	    if (x-1 > 0 && !(field[x-1][y].getBread())){
		moveRange(x-1,y,move,field[x][y]);
	    }
	    if (y+1 < field[x].length && !(field[x][y+1].getBread())){
		moveRange(x,y+1,move,field[x][y]);
	    }
	    if (y-1 > 0 && !(field[x][y-1].getBread())){
		moveRange(x,y-1,move,field[x][y]);
	    }
	}
    }
    //Duly noted that code needs to be adjusted to varying transport types and terrain values.

    public Stack tracePath(int x, int y){
	Stack path = new Stack();
	Terrain prev = field[x][y].getprevTerrain();
	return path;
    }

    public String toString() {
	//builds the string
	String builder = "";
	for (int i = 0; i < field.length; i++) {
	    for (int j = 0; j < field[i].length; j++) {
		//adds every character
		builder += field[i][j].getRep();
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
	newField foo = new newField();
	int a = 0;
	try {
	    
	    Scanner sc = new Scanner(file);
	    while (sc.hasNext()) {
		String s = sc.next();		
		    int k = 0;
		    for (int j = 0; j < foo.field[a].length; j++){
			String temp = s.substring(k,k+1);
			//System.out.println("temp:" + temp + "   a:" + a);
			foo.field[a][j] = foo.field[a][j].TransTer(temp);
			//System.out.println(foo.field[a][j].getRep());
			k++;
		    }
		
		a++;
	    }
   
	}
	catch (Exception e) {
	    System.out.println("something went wrong here");
	}
	//foo.toString();
	//System.out.println(foo);

	foo.setCoor();

	Terrain meh = new Terrain(TypeT.END);
	foo.moveRange(11,6,3,meh);

	for (int x = 0; x < foo.field.length; x++){
	    for (int y = 0; y < foo.field[x].length; y++){
		if (foo.field[x][y].getprevTerrain() != null){
		    int xcor = foo.field[x][y].getXcor();
		    int ycor = foo.field[x][y].getYcor();
		    System.out.println(xcor + ", " + ycor);
		}
	    }
	}

    }

}
