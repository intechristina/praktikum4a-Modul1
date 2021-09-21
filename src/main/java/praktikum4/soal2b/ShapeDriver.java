//package Inheritance;
package praktikum4.soal2b;
import praktikum4.soal2a.*;
import java.util.Scanner;
public class ShapeDriver {
	//method ini tidak perlu anda ubah
	public static Rectangle createRectangle(int a,int b, int c, int d){
		return new Rectangle(new Point(a,b), new Point(c,d));
	}
	//method ini tidak perlu anda ubah
	public static Circle createCircle(int a,int b, int c){
		return new Circle(new Point(a,b), c);
	}
	public static void main(String[] args) {
	/* //Silahkan di-uncomment isi dari main ini setelah kelas Shape dan turunannya serta semua method di kelas-kelas tersebut sudah anda lengkapi
		Scanner scn = new Scanner(System.in);
		int a=0, b=0,c=0,d=0,e=0;
		System.out.print("Input nilai absis I:");
		a=scn.nextInt();
		System.out.print("Input nilai ordinat I:");
		b=scn.nextInt();
		System.out.print("Input nilai absis II:");
		c=scn.nextInt();
		System.out.print("Input nilai Ordinat II:");
		d=scn.nextInt();
		System.out.print(createRectangle(a,b,c,d));
		
		System.out.print("\nInput nilai absis I:");
		a=scn.nextInt();
		System.out.print("Input nilai ordinat I:");
		b=scn.nextInt();
		System.out.print("Input diameter:");
		e=scn.nextInt();
		System.out.print(createCircle(a,b,e));		
	}*/
}