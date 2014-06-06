public class Terrain{

    private final int def;
    private final int movefoot;
    private final String name;
    private Terrain prevTerrain;
    private boolean selected;
    private int xcor;
    private int ycor;
    private String rep;

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

    public Terrain TransTer(String check){
	Terrain replace = new Terrain(1,1,"?","?");
	if (check.equals("p")){
	    replace = new Terrain(1,1,"plain","p");
	    return replace;
	}
	return replace;
    }

}
