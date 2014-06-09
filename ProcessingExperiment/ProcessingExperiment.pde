// Learning Processing
// Daniel Shiffman
// http://www.learningprocessing.com

// Example 16-6: Drawing a grid of squares

// Size of each cell in the grid, ratio of window size to video size
// 80 * 8 = 640
// 60 * 8 = 480
int scale = 64;
boolean redTurn = true;
boolean clicked = false;
float bx;
float by;
int videoScale = 64;
int xpos = 0;
int ypos = 0;
int xpos2 = 128;
int ypos2 = 128;
WarUnit unit = new WarUnit();
// Number of columns and rows in our system
int cols, rows;
PImage img, thing;
PImage img2;
void setup() {
  long lastTime = millis();  
  size(640, 640);
  img = loadImage("infantry.png");
  img2 = loadImage("blueGuy.png");
  thing = loadImage("thing.jpg");
  // Initialize columns and rows
  cols = width/videoScale;
  rows = height/videoScale;
}


void mousePressed() {
  /*stroke(100);
   fill(200);
   rectMode(CENTER);
   rect(mouseX,mouseY,16,16);*/
  if (abs(mouseX - xpos) < 50 || abs(mouseY - ypos) < 50) {
    if (clicked) {
      clicked = false;
      img = loadImage("infantryMoved.png");
    }
    else {
      clicked = true;
      img = loadImage("infantry.png");
    }
  }
  
  if (abs(mouseX - xpos2) < 50 || abs(mouseY - ypos2) < 50) {
    if (clicked) {
      clicked = false;
      img2 = loadImage("blueGuyMoved.png");
    }
    else {
      clicked = true;
      img2 = loadImage("blueGuy.png");
    }
  }
}

void draw() {
  newField screwed = new newField();
  if (keyPressed) {
    if (clicked && unit.range > 0) {
      if (key == 'w' && ypos != 0) {
        ypos-=scale;
        unit.range = unit.range - 1;
      }
      if (key == 's' && ypos < 576) {
        ypos+=scale;
        unit.range = unit.range - 1;
      }
      if (key == 'a' && xpos > 0) {
        xpos-=scale;
        unit.range = unit.range - 1;
      }
      if (key == 'd' && xpos < 576) {
        xpos+=scale;
        unit.range = unit.range - 1;
        
      }
      
    }
  }
  background(0);
  for (int i=0; i<=cols; i++) {
    for (int j=0; j<=rows; j++) {
      int x=i*scale;
      int y=j*scale;
      fill(255);
      //stroke(0);
      image(thing.get(180, 250, 65, 65), x, y);
    }
  }
  image(thing.get(158, 150, 52, 52), 64, 64);
  image(thing.get(158, 150, 52, 52), 128, 64);
  image(thing.get(158, 150, 52, 52), 320, 256);
  image(thing.get(158, 150, 52, 52), 128, 448);
  image(thing.get(158, 150, 52, 52), 512, 256);
  image(img, xpos, ypos, 50, 50);
  image(img2, xpos + 128, ypos + 128, 50,50);
  try {
    Thread.sleep(75);
  }
  catch (Exception e) {
  }
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

  int getRange() {
    return range; 
  }

  void display() {
    image(thing.get(160, 355, 45, 150), xpos, ypos);
  }
}

