//Point.java
package praktikum4.soal2a;
public class Point{
	//attributes
	private int x;
	private int y;
	
	//constructor;
	public Point(){
		x = 0;
		y = 0;
	}
	
	public Point(int newX, int newY){
		x = newX;
		y = newY;
	}
	
	public Point(Point P){
		x = P.getAbsis();
		y = P.getOrdinat();
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
	public boolean equals(Object obj){
		Point p = (Point) obj;
		return (getAbsis() == p.getAbsis() && getOrdinat() == p.getOrdinat());
	}
}