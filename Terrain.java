public enum Terrain{

    plain(1,1);

    private final int def;
    private final int movefoot;

    Terrain(int def, int movefoot){
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
