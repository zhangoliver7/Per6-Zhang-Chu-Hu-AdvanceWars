public enum Terrain{

    plain(1,1,"plain");

    private final int def;
    private final int movefoot;
    private final String name;
    private Terrain prevTerrain;
    private boolean selected;
    private int xcor;
    private int ycor;

    Terrain(int def, int movefoot, String name){
	this.def = def;
	this.movefoot = movefoot;
	this.name = name;
	selected = false;
    }

    public int getXcor(){
	return xcor;
    }

    public int getYcor(){
	return ycor;
    }

    public int[] getCor(){
	int[] result = {xcor,ycor};
	return result;
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

}
