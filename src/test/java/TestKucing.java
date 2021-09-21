//TestKucing.java

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestKucing{

	Kucing cir;

	
	static Stream<Arguments> ciArray3() {
    return Stream.of(
        Arguments.of(1,"Kucing ABC",4,"ABC",4,5, new Kucing(1,"Kucing ABC",4,"ABC",4,5)),
        Arguments.of(2,"Kucing DEF",3,"DEF",6,2, new Kucing (2,"Kucing DEF",3,"DEF",6,2)),
		Arguments.of(5,"Kucing GEF",4,"GEF",1,2, new Kucing (5,"Kucing GEF",4,"GEF",1,2))
    );}
	
	static Stream<Arguments> ciArray4() {
    return Stream.of(
        Arguments.of(1,"Kucing ABC",4,"ABC",4,5, new Kucing(1,"Kucing ABC",4,"ABC", 4,5)),
        Arguments.of(2,"Kucing DEF",3,"DEF",6,2, new Kucing (2,"Kucing DEF",3,"DEF", 6,2)),
		Arguments.of(5,"Kucing GEF",4,"GEF",1,2, new Kucing (5,"Kucing GEF",4,"GEF", 1,2))
    );}
	
	
		static Stream<Arguments> ciArray5a() {
    return Stream.of(
        Arguments.of(new Kucing(1,"Kucing ABC",4,"ABC", 4,5),"bergerak dengan 4 kaki"),
        Arguments.of(new Kucing (2,"Kucing DEF",3,"DEF",6,2),"bergerak dengan 3 kaki"),
		Arguments.of(new Kucing (5,"Kucing GEF",1,"GEF",1,2), "bergerak dengan 1 kaki")
    );}
	
	static Stream<Arguments> ciArray5b() {
    return Stream.of(
        Arguments.of(new Kucing(1,"Kucing ABC",4,"ABC",4,5),"bergerak maju 4 langkah",4,"maju"),
        Arguments.of(new Kucing (2,"Kucing DEF",3,"DEF",6,2),"bergerak mundur 6 langkah",6,"mundur"),
		Arguments.of(new Kucing (5,"Kucing GEF",1,"GEF",1,2), "belok kiri 10 langkah", 10,"kiri"),
		Arguments.of(new Kucing(1,"Kucing ABC",4,"ABC",3,4),"belok kanan 4 langkah",4,"kanan"),
        Arguments.of(new Kucing (2,"Kucing DEF",3,"DEF",7,8),"bergerak ditempat",6,"lain")
    );}
	
	static Stream<Arguments> ciArray6() {
    return Stream.of(
        Arguments.of(new Kucing(1,"Kucing ABC",4,"ABC",4,5),"daging", "sedang makan daging"),
        Arguments.of(new Kucing (2,"Kucing DEF",3,"DEF",6,2),"tulang","sedang makan tulang"),
		Arguments.of(new Kucing (5,"Kucing GEF",1,"GEF",1,2),"ayam","sedang makan ayam")
    );}
	
	static Stream<Arguments> ciArray7() {
    return Stream.of(
        Arguments.of(new Kucing(1,"Kucing ABC",4,"ABC",4,5),"Nama: ABC, jenis: Kucing ABC, usia: 1 tahun, jumlah kaki: 4, posisi (4,5)"),
        Arguments.of(new Kucing (2,"Kucing DEF",3,"DEF",6,2),"Nama: DEF, jenis: Kucing DEF, usia: 2 tahun, jumlah kaki: 3, posisi (6,2)"),
		Arguments.of(new Kucing (5,"Kucing GEF",1,"GEF",1,2),"Nama: GEF, jenis: Kucing GEF, usia: 5 tahun, jumlah kaki: 1, posisi (1,2)")
    );}
	
	@ParameterizedTest
	@MethodSource("ciArray3")
	public void testKonstruktor(int usia,String jenis,int jmlKaki,String nama, int x, int y,Kucing c) {
		cir = new Kucing(usia, jenis, jmlKaki, nama, x, y);
		assertThat(c.getJenis(), equalToIgnoringCase(cir.getJenis()));
		assertEquals(c.getUsia(), cir.getUsia());
		assertEquals(c.getJmlKaki(), cir.getJmlKaki());
		assertEquals(c.getPosisi().getAbsis(), cir.getPosisi().getAbsis());
		assertEquals(c.getPosisi().getOrdinat(), cir.getPosisi().getOrdinat());
		assertThat(c.getNama(), equalToIgnoringCase(cir.getNama()));
	}
	
	@ParameterizedTest
	@MethodSource("ciArray4")
	void testSetter(int usia,String jenis,int jmlKaki,String nama, int x, int y,Kucing c) {
		cir = new Kucing(5,"Kucing GEF",1,"GEF",1,2);
		cir.setUsia(usia);
		cir.setJenis(jenis);
		cir.setJmlKaki(jmlKaki);
		cir.setNama(nama);
		cir.setPosisi(new Point(x,y));
		assertThat(c.getJenis(), equalToIgnoringCase(cir.getJenis()));
		assertEquals(c.getUsia(), cir.getUsia());
		assertEquals(c.getJmlKaki(), cir.getJmlKaki());
		assertEquals(c.getPosisi().getAbsis(), cir.getPosisi().getAbsis());
		assertEquals(c.getPosisi().getOrdinat(), cir.getPosisi().getOrdinat());
		assertThat(c.getNama(), equalToIgnoringCase(cir.getNama()));
	}
	
	@ParameterizedTest
	@MethodSource("ciArray5a")
	void testBergerak1(Kucing c, String output) {
		assertEquals(c.bergerak(), output); 
	}
	
	@ParameterizedTest
	@MethodSource("ciArray5b")
	void testBergerak2(Kucing c, String output, int langkah, String arah) {
		
		assertEquals(c.bergerak(langkah,arah), output); 
	}
	
	@ParameterizedTest
	@MethodSource("ciArray6")
	void testMakan(Kucing d, String c, String h) {
		assertEquals(d.makan(c), h); 
	}
	
	@Test
	void testBersuara() {
		cir = new Kucing(1,"Kucing ABC",4,"ABC",1,2);
		assertEquals(cir.bersuara(), "Miaw..miaw..miaw..");
	}
	@ParameterizedTest
	@MethodSource("ciArray7")
	void testToString(Kucing c, String s) {
		assertThat(c.toString(), containsString(s));
	}
	
	
}