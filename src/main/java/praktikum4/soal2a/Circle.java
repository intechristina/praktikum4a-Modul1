//Circle.java
package praktikum4.soal2a;
public class Circle {
	//tulis semua deklarasi atribut di sini
	
	
	//tulis konstruktor tanpa parameter di sini, nilai default objek Circle adalah: (0,0) dengan diameter 1
	
	
	//tulis konstruktor dengan parameter di sini
	
	
	//tulis kopi konstruktor di sini
	
	
	//tulis semua method setter di sini
	
	
	//tulis semua method getter di sini
	
	
	
	//tulis method getArea() di sini, yang mengembalikan luas dari objek this dengan rumus: PI x r x r
	// r = diameter/2
	
	

	//tulis method getCircumference() di sini, yang mengembalikan keliling dari objek this dengan rumus: 2 x PI x r 
	// r = diameter/2
	
	

	//tulis method toString, lihat contoh keluaran yang diberikan pada deskripsi praktikum
	
	
	//method ini tidak boleh dihapus atau diubah
	public boolean equals(Object obj){
		Circle cir = (Circle) obj;
		return (getP().equals(cir.getP()) && getDiameter() == cir.getDiameter());
	}
	
}
