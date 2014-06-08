public class Terrain{

    private int def;
    private int movefoot;
    private String name;
    private Terrain prevTerrain;
    private boolean selected;
    private boolean bread;
    private int xcor;
    private int ycor;
    private String rep;
    private Unit guy;
    private TypeT type;

    Terrain(TypeT type){
	this.type = type;
    }

    public void evaluate(){
	switch (type){
	case PLAIN:
	    def = 1;
	    movefoot = 1;
	    name = "plain";
	    rep = "p";
	    break;
	
	case MOUNTAIN:
	    def = 5;
	    movefoot = 2;
	    name = "mountain";
	    rep = "m";
	    break;
	
	case FOREST:
	    def = 3;
	    movefoot = 1;
	    name = "forest";
	    rep = "f";
	    break;
	}
    }

    Terrain(int def, int movefoot, String name, String rep){
	this.def = def;
	this.movefoot = movefoot;
	this.name = name;
	this.rep = rep;
	selected = false;
    }

    public int getXcor(){
	return xcor;
    }

    public String getRep(){
	return rep;
    }

    public void setRep(String x){
	rep = x;
    }

    public int getYcor(){
	return ycor;
    }

    public int[] getCor(){
	int[] result = {xcor,ycor};
	return result;
    }

    public boolean getBread(){
	return bread;
    }

    public void toggleBread(){
        bread = !(bread);
    }

    public void setXcor(int x){
	xcor = x;
    }

    public void setYcor(int y){
	ycor = y;
    }

    public int getDef(){
	return def;
    }

    public int getMovefoot(){
	return movefoot;
    }

    public void toggleSelect(){
	selected = !(selected);
    }

    public void clearSelect(){
	selected = false;
    }

    public void clearHistory(){
	prevTerrain = null;
    }

    public void setprevTerrain(Terrain prev){
	prevTerrain = prev;
    }

    public Terrain getprevTerrain() {
	return prevTerrain;
    }

    public String getName(){
	return name;
    }

    public static Terrain TransTer(String check){
	Terrain replace = new Terrain(1,1,"?","?");
	if (check.equals("p")){
	    replace = new Terrain(1,1,"plain","p");
	    return replace;
	}
	return replace;
    }

    public String toString(){
	return getName();
    }

    public static void main(String[] args){
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
