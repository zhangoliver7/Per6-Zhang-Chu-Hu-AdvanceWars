// Learning Processing
// Daniel Shiffman
// http://www.learningprocessing.com

// Example 16-6: Drawing a grid of squares

// Size of each cell in the grid, ratio of window size to video size
// 80 * 8 = 640
// 60 * 8 = 480
int videoScale = 60;
int xpos = 60;
int ypos = 60;
// Number of columns and rows in our system
int cols, rows;
PImage img;
void setup() {
    
  size(640,640);
  img = loadImage("Mario Face.png");
  // Initialize columns and rows
  cols = width/videoScale;
  rows = height/videoScale;
}


void mousePressed() {
  stroke(100);
  fill(200);
  rectMode(CENTER);
  rect(mouseX,mouseY,16,16);
}

/*void keyPressed() {
  switch(keyCode) {
    case 39:
      //rect(xpos,ypos, 100,100);
      xpos = xpos + 10;
    case 41:
      //rect(xpos,ypos, 100,100);
      ypos += 10;
  }
}*/

void draw() {
  if (keyPressed) {
   if (key == 'w') {
     ypos-=10;
   }
   if (key == 's') {
     ypos+=10;
   }
   if (key == 'a') {
     xpos-=10;
   }
   if (key == 'd') {
     xpos+=10;
   }
  }
  background(0);
  image(img,xpos + 100,ypos + 100,50,50);
  rect(xpos,ypos, 100,150);
  // Begin loop for columns
  /*for (int i = 0; i < cols; i++) {
    // Begin loop for rows
    for (int j = 0; j < rows; j++) {
      
      // Scaling up to draw a rectangle at (x,y)
      int x = i*videoScale;
      int y = j*videoScale;
      fill(255);
      stroke(0);
      // For every column and row, a rectangle is drawn at an (x,y) location scaled and sized by videoScale.
      rect(x,y,videoScale,videoScale);
      
    }
  }
  rect(10,10,videoScale * 0.6, videoScale * 0.6); 
  */
}

