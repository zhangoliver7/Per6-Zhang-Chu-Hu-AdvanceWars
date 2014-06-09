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

    public Terrain[][] getField(){
	return field;
    }

    //GIVES EVERY TERRAIN A CORROSPONDING COORDINATE

    public void setCoor(){
  for (int x = 0; x < field.length; x++)
      for (int y = 0; y < field[x].length; y++){
    field[x][y].setXcor(x);
    field[x][y].setYcor(y);
      }
    }

    //MOVEMENT RANGE OF A UNIT

    //very easy to break code if x,y not in field
    //However, I highly doubt this function will be called in such a situation.
    //pathfinding gogogogogogogogo
    public void moveRange(int x, int y, int move, Terrain prev){
  if (move >= 0){
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
  for (int a = 0; a<field.length ; a++)
      for (int b = 0; b<field[a].length ; b++)
    field[a][b].clearBread();
    }
    //Duly noted that code needs to be adjusted to varying transport types and terrain values.
    //As well as the inability to pass through enemy units.

    //Returns a Stack of Terrain leading to the destination field[x][y]
    public Stack<Terrain> tracePath(int x, int y){
  Stack<Terrain> path = new Stack<Terrain>();
  path.push(field[x][y]);
  Terrain prev = field[x][y].getprevTerrain();
  Terrain bleh = new Terrain(TypeT.END);
  while (prev.getRep() != bleh.getRep()){
      path.push(prev);
      prev = prev.getprevTerrain();
  }
  return path;
    }

    //ATTACK RANGE OF A UNIT

    //This code doesn't look like a previous one at all. :p
    public void attackRange(int x, int y, int range, int side){
  if (range >= 0){
      range -= 1;
      if (field[x][y].hasUnit()){
    //System.out.println("Unit here!");
    if (field[x][y].getGuy().getSide() != side){
        //System.out.println("Enemy here!");
        field[x][y].toggleAttacked();
    }
      }
      field[x][y].toggleBread();
      if (x+1 < field.length && !(field[x+1][y].getBread())){
    attackRange(x+1,y,range,side);
      }
      if (x-1 > 0 && !(field[x-1][y].getBread())){
    attackRange(x-1,y,range,side);
      }
      if (y+1 < field[x].length && !(field[x][y+1].getBread())){
    attackRange(x,y+1,range,side);
      }
      if (y-1 > 0 && !(field[x][y-1].getBread())){
    attackRange(x,y-1,range,side);
      }
  }
  for (int a = 0; a<field.length ; a++)
      for (int b = 0; b<field[a].length ; b++)
    field[a][b].clearBread();
    }

    //Returns a stack of units that can be attacked
    public Stack<Unit> getTargets(){
  Stack<Unit> targets = new Stack<Unit>();
  for (int x = 0; x < field.length; x++)
      for (int y = 0; y < field[x].length; y++)
    if (field[x][y].getAttacked())
        targets.push(field[x][y].getGuy());
  return targets;
    }

    //TESTING FUNCTIONS - CAN SKIP

    public void printUnit(Stack<Unit> x){
  while(!(x.empty())){
      Unit y = x.pop();
      System.out.println(y.getXcor() + ", " + y.getYcor());
  }
    }
    
    public void printPath(Stack<Terrain> x){
  while (!(x.empty())){
      Terrain y = x.pop();
      System.out.println(y.getXcor() + ", " + y.getYcor());
  }
    }

    //TOSTRING FUNCTION

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

    public void translateFile(File file){
	int a = 0;
	try {
	    System.out.println("passed here");
	    Scanner sc = new Scanner(file);
	    while (sc.hasNext()) {
		String s = sc.next();    
		int k = 0;
		for (int j = 0; j < field[a].length; j++){
		    String temp = s.substring(k,k+1);
		    System.out.println("temp:" + temp + "   a:" + a);
		    field[a][j] = field[a][j].TransTer(temp);
		    //System.out.println(foo.field[a][j].getRep());
		    k++;
		}
		
		a++;
	    }
	}
	catch (Exception e) {
	    System.out.println("something went wrong here");
	}	
    }

    //THE TESTING GROUNDS

    public static void main(String[] args) {
  File file = new File("Field1.txt");
  newField foo = new newField();
  foo.translateFile(file);
  /*
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
  */
  foo.toString();
  System.out.println(foo);

  foo.setCoor();

  Terrain meh = new Terrain(TypeT.END);
  //foo.moveRange(11,6,3,meh);
  /*
  for (int x = 0; x < foo.field.length; x++){
      for (int y = 0; y < foo.field[x].length; y++){
    if (foo.field[x][y].getprevTerrain() != null){
        int xcor = foo.field[x][y].getXcor();
        int ycor = foo.field[x][y].getYcor();
        System.out.println(xcor + ", " + ycor);
    }
      }
  }

  foo.printPath(foo.tracePath(12,5));
  */
  /*
  Unit redshirt = new Unit(TypeU.INFANTRY);
  redshirt.evaluate();
  redshirt.setSide(1);
  foo.field[11][6].setGuy(redshirt);
  Unit blueshirt = new Unit(TypeU.INFANTRY);
  blueshirt.evaluate();
  blueshirt.setSide(-1);
  foo.field[10][6].setGuy(blueshirt);
        foo.attackRange(11,6,1,1);
  foo.printUnit(foo.getTargets());
  */
    }
    

}
