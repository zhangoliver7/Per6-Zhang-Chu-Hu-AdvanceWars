int scale = 64;
int cols,rows;

float bx;
float by;
int boxSize = 25;
boolean overBox = false;
boolean locked = false;
float xOffset = 0.0; 
float yOffset = 0.0; 

void setup() {
  size (640, 640);
  cols=width/scale;
  rows=height/scale;
  bx = width/2.0;
  by = height/2.0;
  rectMode(RADIUS);  
}

void draw() {
  for (int i=0; i<=cols; i++) {
    for (int j=0; j<=rows; j++) {
      int x=i*scale;
      int y=j*scale;
      fill(255);
      stroke(0);
      rect(x, y, scale, scale);
    }
  }  
  // Test if the cursor is over the box 
  if (mouseX > bx-boxSize && mouseX < bx+boxSize && 
      mouseY > by-boxSize && mouseY < by+boxSize) {
    overBox = true;  
    if(!locked) { 
      //stroke(0); 
      //fill(185);
    } 
  } else {
    //stroke(0);
    //fill(185);
    overBox = false;
  }
  
  // Draw the box
  rect(bx, by, boxSize, boxSize);
}

void mousePressed() {
  if(overBox) { 
    locked = true; 
  } else {
    locked = false;
  }
  xOffset = mouseX-bx; 
  yOffset = mouseY-by; 

}

void mouseDragged() {
  if(locked) {
    bx = mouseX-xOffset; 
    by = mouseY-yOffset; 
  }
}

void mouseReleased() {
  locked = false;
}


