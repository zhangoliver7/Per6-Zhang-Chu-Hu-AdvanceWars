// Learning Processing
// Daniel Shiffman
// http://www.learningprocessing.com

// Example 16-6: Drawing a grid of squares

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
int videoScale = 64;
int xpos = 0;
int ypos = 0;
// Number of columns and rows in our system
int cols, rows;
PImage img, thing;
void setup() {
  long lastTime = millis();  
  size(640, 640);
  img = loadImage("infantry.png");
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
}

void draw() {
  if (keyPressed) {
    if (clicked) {
      if (key == 'w' && ypos != 0) {
        ypos-=scale;
      }
      if (key == 's' && ypos < 576) {
        ypos+=scale;
      }
      if (key == 'a' && xpos > 0) {
        xpos-=scale;
      }
      if (key == 'd' && xpos < 576) {
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
  try {
    Thread.sleep(75);
  }
  catch (Exception e) {
  }
}

