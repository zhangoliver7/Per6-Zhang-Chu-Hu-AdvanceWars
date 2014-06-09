public class Unit {

  private int attack;
  private int hp;
  private int range;
  private int moveRange;
  private int side;
  private int xcor;
  private int ycor;
  boolean clicked = false;
  private TypeU type;

  //CONSTRUCTOR METHODS

  public Unit(int attack, int hp, int range, int moveRange) {
    this.attack = attack;
    this.hp = hp;
    this.range = range;
    this.moveRange = moveRange;
  }

  public Unit(TypeU x) {
    type = x;
  }

  public void evaluate() {
    switch(type) {
    case INFANTRY:
      hp = 100;
      range = 1;
      moveRange = 3;
      attack = 1;
      break;
    }
  }

  //COORDINATE FUNCTIONS

  public int getXcor() {
    return xcor;
  }

  public int getYcor() {
    return ycor;
  }

  public int[] getCor() {
    int[] result = {
      xcor, ycor
    };
    return result;
  }

  public void setXcor(int x) {
    xcor = x;
  }

  public void setYcor(int y) {
    ycor = y;
  }

  //ALLIANCE

  public void setSide(int side) {
    this.side = side;
  }

  public int getSide() {
    return side;
  }

  //GAMEPLAY FUNCTIONS

  public int getAttack() {
    return attack;
  }

  public int getHP() {
    return hp;
  }

  public int getRange() {
    return range;
  }

  public int getMoveRange() {
    return moveRange;
  }

  //Processing requirements
  
}

