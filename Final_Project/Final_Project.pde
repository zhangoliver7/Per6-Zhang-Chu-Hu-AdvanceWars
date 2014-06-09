import java.util.*;
import java.io.*;

File a;
newField battle;
Terrain[][] field;
int xselected;
int yselected;

void setup(){
  a = new File ("Field1.txt");
  battle = new newField();
  processFile(a,battle);
  field = battle.getField();
  size(field[1].length*40,field.length*40);
  xselected = 10;
  yselected = 10;
  Unit redshirt = new Unit(TypeU.INFANTRY);
  redshirt.evaluate();
  redshirt.setSide(1);
  Unit blueshirt = new Unit(TypeU.INFANTRY);
  blueshirt.evaluate();
  blueshirt.setSide(-1);
  field[5][5].setGuy(redshirt);
  field[11][7].setGuy(blueshirt);
  battle.setField(field);
}

void draw(){
 background(0);
 field = battle.getField();
 lightRange();
 for(int x = 0; x < field.length; x++){
   for(int y = 0; y < field[x].length; y++){
    if (field[x][y].getRep().equals("p")){
     fill(120,255,0);
    }
    if (field[x][y].getRep().equals("m")){
     fill(230,235,5);
    }
    if (field[x][y].getRep().equals("f")){
     fill(20,195,5);
    }
    if (field[x][y].getRep().equals("?")){
     fill(250,250,250);
    }
    rectMode(CORNER);
    rect(y*40,x*40,40,40);
    if (field[x][y].getprevTerrain() != null){
     fill(0,180,255);
     rect(y*40,x*40,40,40); 
    }
    if (field[x][y].getSelect()){
      fill(222,0,255);
      rect(y*40,x*40,40,40);
      /*
      line(y*40,x*40,(y+1)*40,x*40);
      fill(222,0,255);
      line((y+1)*40,x*40,(y+1)*40,(x+1)*40);
      fill(222,0,255);
      line((y+1)*40,(x+1)*40,y*40,(x+1)*40);
      fill(222,0,255);
      line(y*40,(x+1)*40,y*40,x*40);
      */
    }
    if (field[x][y].hasUnit()){
     if (field[x][y].getGuy().getSide() == 1){
      fill(200,0,0); 
     }
     if (field[x][y].getGuy().getSide() == -1){
      fill(0,0,200); 
     }
     ellipse(y*40 + 20, x*40 + 20, 35, 35);
    }
   }
 }
}

void processFile(File file, newField battle){
  Terrain[][] stuff = battle.getField();
  String[] lines = loadStrings("Field1.txt");
  for(int x = 0; x < lines.length; x++){
    int y = 0;
    while(y < lines[x].length()){
      String temp = lines[x].substring(y,y+1);
      stuff[x][y] = stuff[x][y].TransTer(temp);
      y++; 
    } 
  }
  battle.setField(stuff);
}

void mousePressed(){
 Terrain[][] field = battle.getField();
 int x = mouseY / 40;
 int y = mouseX / 40;
 if(xselected != -10){
  field[xselected][yselected].clearSelect();
 }
 if(xselected != x && yselected != y){
  xselected = x;
  yselected = y;
  field[x][y].toggleSelect();
 }
 else{
  xselected = -10;
  yselected = -10; 
 }
 for (int a = 0; a < field.length; a++)
  for (int b = 0; b < field[a].length; b++)
    field[a][b].clearHistory();
 battle.setField(field);
}

void lightRange(){
 Terrain[][] field = battle.getField();
 Terrain bleh = new Terrain(TypeT.END);
 bleh.evaluate();
 if (keyPressed){
  if ((key == 's' && xselected != -10) && field[xselected][yselected].hasUnit()){
    battle.moveRange(xselected,yselected,field[xselected][yselected].getGuy().getMoveRange(),bleh);
  }
 } 
}
