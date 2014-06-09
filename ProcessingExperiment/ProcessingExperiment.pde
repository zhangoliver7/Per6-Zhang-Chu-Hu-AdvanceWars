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
int videoScale = 60;
int xpos = 10;
int ypos = 10;
// Number of columns and rows in our system
int cols, rows;
PImage img;
void setup() {
  long lastTime = millis();  
  size(640, 640);
  img = loadImage("Mario Face.png");
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
      //stroke(0);
      rect(x, y, scale, scale);
    }
  }  
  // Test if the cursor is over the box 
  if (mouseX > bx-boxSize && mouseX < bx+boxSize && 
    mouseY > by-boxSize && mouseY < by+boxSize) {
    overBox = true;  
    if (!locked) {
    }
  } 
  else {

    overBox = false;
  }
  image(img, xpos, ypos, 50, 50);
  try {
    Thread.sleep(80);
  }
  catch (Exception e) {
  }
}

