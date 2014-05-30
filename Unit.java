public class Unit{
    
    private int attack;
    private int hp;
    private int range;
    private int moveRange;
    private String alliance;

    public Unit(int attack, int hp, int range, int moveRange){
	this.attack = attack;
	this.hp = hp;
	this.range = range;
	this.moveRange = moveRange;
    }

    public void setAlliance(String side){
	alliance = side;
    }

    public int getAttack(){
	return attack;
    }

    public int getHP(){
	return hp;
    }

    public int getRange(){
	return range;
    }

    public int getMoveRange(){
	return moveRange;
    }

    public String getAlliance(){
	return alliance;
    }

}
