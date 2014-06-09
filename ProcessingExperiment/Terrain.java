public class Terrain {

  private int def;
  private int movefoot;
  private String name;
  private Terrain prevTerrain;
  private boolean selected;
  private boolean bread;
  private int xcor;
  private int ycor;
  private String rep;
  private boolean guyhere;
  private Unit guy;
  private TypeT type;
  private boolean attacked;

  //CONSTRUCTOR FUNCTIONS

  Terrain(TypeT type) {
    this.type = type;
  }

  public void evaluate() {
    switch (type) {
    case PLAIN:
      def = 1;
      movefoot = 1;
      name = "plain";
      rep = "p";
      selected = false;
      break;

    case MOUNTAIN:
      def = 5;
      movefoot = 2;
      name = "mountain";
      rep = "m";
      selected = false;
      break;

    case FOREST:
      def = 3;
      movefoot = 1;
      name = "forest";
      rep = "f";
      selected = false;
      break;

    case END:
      name = "end";
      rep = "e";
      selected = false;
      break;
    }
  }

  Terrain(int def, int movefoot, String name, String rep) {
    this.def = def;
    this.movefoot = movefoot;
    this.name = name;
    this.rep = rep;
    selected = false;
  }

  //GETTING COORDINATES

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

  //GETTING TRACKER VARIABLES

  //REP FROM TXT FILE

  public String getRep() {
    return rep;
  }

  public void setRep(String x) {
    rep = x;
  }

  //BREAD CRUMBS

  public boolean getBread() {
    return bread;
  }

  public void toggleBread() {
    bread = !(bread);
  }

  public void clearBread() {
    bread = false;
  }

  //SELECTED TERRAIN

  public boolean getSelect() {
    return selected;
  }

  public void toggleSelect() {
    selected = !(selected);
  }

  public void clearSelect() {
    selected = false;
  }

  //PREVTERRAIN

  public void clearHistory() {
    prevTerrain = null;
  }

  public void setprevTerrain(Terrain prev) {
    prevTerrain = prev;
  }

  public Terrain getprevTerrain() {
    return prevTerrain;
  }

  //NAME

  public String getName() {
    return name;
  }

  //UNITS ON TERRAIN

  public Unit getGuy() {
    return guy;
  }

  public void setGuy(Unit mook) {
    guy = mook;
    guy.setXcor(this.xcor);
    guy.setYcor(this.ycor);
    this.toggleHere();
  }

  public boolean hasUnit() {
    return guyhere;
  }

  public void toggleHere() {
    guyhere = !(guyhere);
  }

  //UNITS GETTING ATTACKED

  public boolean getAttacked() {
    return attacked;
  }

  public void toggleAttacked() {
    attacked = !(attacked);
  }

  public void clearAttacked() {
    attacked = false;
  }

  //GAMEPLAY VALUES

  public int getDef() {
    return def;
  }

  public int getMovefoot() {
    return movefoot;
  }

  public static Terrain TransTer(String check) {
    Terrain replace = new Terrain(1, 1, "?", "?");
    if (check.equals("p")) {
      replace = new Terrain(TypeT.PLAIN);
      replace.evaluate();
      return replace;
    }
    return replace;
  }

  public String toString() {
    return getName();
  }

  public static void main(String[] args) {
    Terrain test = new Terrain(TypeT.PLAIN);
    test.evaluate();
    System.out.println(test.getName());
    Terrain next = new Terrain(TypeT.MOUNTAIN);
    next.evaluate();
    System.out.println(next.getName());
    Terrain nyeh = new Terrain(TypeT.FOREST);
    nyeh.evaluate();
    System.out.println(nyeh.getName());
  }
}

