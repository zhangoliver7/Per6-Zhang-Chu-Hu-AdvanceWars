import java.util.*;
import java.io.*;

File a;
newField battle;
Terrain[][] field;

void setup(){
  a = new File ("Field1.txt");
  battle = new newField();
  processFile(a,battle);
  field = battle.getField();
  size(field[1].length*50,field.length*50);
}

void draw(){
 background(0);
 field = battle.getField();
 for(int x = 0; x < field.length; x++){
   for(int y = 0; y < field[x].length; y++){
    if (field[x][y].getRep().equals("p")){
     fill(120,255,0);
    }
    if (field[x][y].getRep().equals("?")){
     fill(250,250,250);
    }
    rectMode(CORNER);
    rect(y*50,x*50,50,50); 
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
