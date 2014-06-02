public enum Terrain{

    plain(1,1);

    private final int def;
    private final int movefoot;
    private final String name;


    Terrain(int def, int movefoot, String name){
	this.def = def;
	this.movefoot = movefoot;
	this.name = name;
    }

    public int getDef(){
	return def;
    }

    public int getMovefoot(){
	return movefoot;
    }

}
