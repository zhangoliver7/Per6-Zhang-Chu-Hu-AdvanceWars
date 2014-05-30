public class Terrain{

    private final int def;
    private final int movefoot;

    public Terrain(int def, int movefoot){
	this.def = def;
	this.movefoot = movefoot;
    }

    public int getDef(){
	return def;
    }

    public int getMovefoot(){
	return movefoot;
    }

}
