class WarUnit {
  int hp, att, def, range, attrange;
  PImage img;
  
  WarUnit() {
   hp = 10;
   att = 5;
   def = 5;
   range = 3;
   attrange = 1;
   img = loadImage("thing.jpg"); 
  }
  
  void display() {
    stroke(0);
    fill(100);
    rectMode(CENTER);
    rect(0,0,100,100);
    image(img.get(100,402,100,100));
  }
}

