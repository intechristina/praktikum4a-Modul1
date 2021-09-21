//Rectangle.java
package praktikum4.soal2a;
public class Rectangle {
	//tulis semua deklarasi atribut di sini


	//tulis konstruktor tanpa parameter di sini, nilai default objek Rectangle adalah: (0,0), (0,0) 
	

	//tulis konstruktor dengan parameter di sini
	
	
	//tulis kopi konstruktor dengan parameter di sini
	

	//tulis semua method setter di sini
	
	
	//tulis semua method getter di sini

	
	//tulis method getWidth() di sini yang akan mengembalikan lebar dari objeck rectangle dengan rumus absis1 - absis 2
	

	//tulis method getHeight() di sini yang akan mengembalikan panjang dari objeck rectangle dengan rumus ordinat1 - ordinat2
	
	
	
	//tulis method getArea() di sini, yang mengembalikan luas dari objek this dengan rumus: panjang x lebar
	
	
	//tulis method getCircumference() di sini, yang mengembalikan keliling dari objek this dengan rumus: 2 x (panjang + lebar)
	
	

	//method ini tidak perlu anda ubah
	public String toString(){
		return(
			"\n" + getName() + 
			" with :\n\tPoint P1: " + p1 +
			"\n\tPoint P2: " + p2 +
			"\n\twidth : " + getWidth() +
			"\n\theight : " + getHeight() +
			"\n\tLuas : " + getArea() +
			"\n\tKeliling : " + getCircumference()
		);
	}
	
	//method ini tidak boleh dihapus atau diubah
	public boolean equals(Object obj){
		Rectangle rec = (Rectangle) obj;
		return (getP1().equals(rec.getP1()) && getP2().equals(rec.getP2()));
	}

}
