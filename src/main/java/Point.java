public class Point{
	private int x;
	private int y;
	
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	//setter
	public void setAbsis(int newX){
		x = newX;
	}
	public void setOrdinat(int newY){
		y = newY;
	}
	
	//getter
	public int getAbsis(){
		return x;
	}
	public int getOrdinat(){
		return y;
	}
	public String toString(){
		return ("("+x+","+y+")");
	}
}