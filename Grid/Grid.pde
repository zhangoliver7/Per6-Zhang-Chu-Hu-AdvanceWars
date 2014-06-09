// Size of each cell in the grid, ratio of window size to video size
// 80 * 8 = 640
// 60 * 8 = 480
int scale = 64;

boolean clicked = false;
float bx;
float by;
int boxSize = 25;
boolean overBox = false;
boolean locked = false;
float xOffset = 0.0; 
float yOffset = 0.0; 
int videoScale = 60;
int xpos = 225;
int ypos = 10;
// Number of columns and rows in our system
int cols, rows;
PImage thing;
WarUnit unit;
boolean mouseShowText;

void setup() {
  long lastTime = millis();  
  size(1000, 700);
  thing = loadImage("thing.jpg");
  // Initialize columns and rows
  cols = width/videoScale;
  rows = height/videoScale;
  unit = new WarUnit();
}


void mousePressed() {
  /*stroke(100);
   fill(200);
   rectMode(CENTER);
   rect(mouseX,mouseY,16,16);*/
  if (abs(mouseX - xpos) < 50 || abs(mouseY - ypos) < 50) {
    if (clicked)
      clicked = false;
    else 
      clicked = true;
  }
}

void draw() {
  if (keyPressed) {
    if (clicked) {
      if (key == 'w') {
        ypos-=scale;
      }
      if (key == 's') {
        ypos+=scale;
      }
      if (key == 'a') {
        xpos-=scale;
      }
      if (key == 'd') {
        xpos+=scale;
      }
    }
  }
  background(0);
  for (int i=0; i<=cols; i++) {
    for (int j=0; j<=rows; j++) {
      int x=i*scale;
      int y=j*scale;
      fill(255);
      image(thing.get(180, 250, 65, 65), x, y);
    }
  }
  int i=0;
  while (i<4) {
    int j=0;
    while (j<8) {
      image(thing.get(158, 150, 52, 52), i*50, j*50);
      j++;
    }
    i++;
  }
  try {
    Thread.sleep(75);
  }
  catch (Exception e) {
  }
  unit.display();
  if (dist(mouseX, mouseY, xpos, ypos)<30) {
    fill(0);
    text("HP:"+unit.hp+", Attack:"+unit.att+", Def:"+unit.def+",\nRange:"
    +unit.range+", AttRange:"+unit.attrange, mouseX+5, mouseY+5);
  }
}

class WarUnit {
  int hp, att, def, range, attrange;
  int x, y;
  PImage img1;

  WarUnit() {
    hp = 10;
    att = 5;
    def = 5;
    range = 3;
    attrange = 1;
    img1 = loadImage("thing.jpg");
  }

  void display() {
    image(thing.get(160, 355, 45, 150), xpos, ypos);
  }
}

