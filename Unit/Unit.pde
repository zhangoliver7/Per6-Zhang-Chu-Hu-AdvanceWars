
WarUnit a;
void setup() {
  size(200,200);
  a = new WarUnit();
}

void draw() {
  background(255);
  a.display();
}

class WarUnit {
  int hp, att, def, range, attrange;
  PImage img;
  
  WarUnit() {
   hp = 10;
   att = 5;
   def = 5;
   range = 3;
   attrange = 1;
   img = loadImage("infantry.png"); 
  }
  
  void display() {
    stroke(0);
    fill(100);
    rectMode(CENTER);
    rect(0,0,100,100);
    image(img,0,0);
  }
}

