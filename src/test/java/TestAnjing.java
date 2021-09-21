//TestAnjing.java

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


public class TestAnjing {

	Anjing cir;

	
	static Stream<Arguments> ciArray3() {
    return Stream.of(
        Arguments.of(1,"Anjing ABC",4,"ABC", new Anjing(1,"Anjing ABC",4,"ABC")),
        Arguments.of(2,"Anjing DEF",3,"DEF", new Anjing (2,"Anjing DEF",3,"DEF")),
		Arguments.of(5,"Anjing GEF",4,"GEF", new Anjing (5,"Anjing GEF",4,"GEF"))
    );}
	
	static Stream<Arguments> ciArray4() {
    return Stream.of(
        Arguments.of(1,"Anjing ABC",4,"ABC", new Anjing(1,"Anjing ABC",4,"ABC")),
        Arguments.of(2,"Anjing DEF",3,"DEF", new Anjing (2,"Anjing DEF",3,"DEF")),
		Arguments.of(5,"Anjing GEF",4,"GEF", new Anjing (5,"Anjing GEF",4,"GEF"))
    );}
	
	
		static Stream<Arguments> ciArray5() {
    return Stream.of(
        Arguments.of(new Anjing(1,"Anjing ABC",4,"ABC"),"bergerak dengan 4 kaki"),
        Arguments.of(new Anjing (2,"Anjing DEF",3,"DEF"),"bergerak dengan 3 kaki"),
		Arguments.of(new Anjing (5,"Anjing GEF",1,"GEF"), "bergerak dengan 1 kaki")
    );}
	
	static Stream<Arguments> ciArray6() {
    return Stream.of(
        Arguments.of(new Anjing(1,"Anjing ABC",4,"ABC"),"daging", "sedang makan daging"),
        Arguments.of(new Anjing (2,"Anjing DEF",3,"DEF"),"tulang","sedang makan tulang"),
		Arguments.of(new Anjing (5,"Anjing GEF",1,"GEF"),"ayam","sedang makan ayam")
    );}
	
	static Stream<Arguments> ciArray7() {
    return Stream.of(
        Arguments.of(new Anjing(1,"Anjing ABC",4,"ABC"),"Nama: ABC, jenis: Anjing ABC, usia: 1 tahun, jumlah kaki: 4"),
        Arguments.of(new Anjing (2,"Anjing DEF",3,"DEF"),"Nama: DEF, jenis: Anjing DEF, usia: 2 tahun, jumlah kaki: 3"),
		Arguments.of(new Anjing (5,"Anjing GEF",1,"GEF"),"Nama: GEF, jenis: Anjing GEF, usia: 5 tahun, jumlah kaki: 1")
    );}
	
	@ParameterizedTest
	@MethodSource("ciArray3")
	public void testKonstruktor(int usia,String jenis,int jmlKaki,String nama, Anjing c) {
		cir = new Anjing(usia, jenis, jmlKaki, nama);
		assertThat(c.getJenis(), equalToIgnoringCase(cir.getJenis()));
		assertEquals(c.getUsia(), cir.getUsia());
		assertEquals(c.getJmlKaki(), cir.getJmlKaki());
		assertThat(c.getNama(), equalToIgnoringCase(cir.getNama()));
	}
	
	@ParameterizedTest
	@MethodSource("ciArray4")
	void testSetter(int usia,String jenis,int jmlKaki,String nama, Anjing c) {
		cir = new Anjing(5,"Anjing GEF",1,"GEF");
		cir.setUsia(usia);
		cir.setJenis(jenis);
		cir.setJmlKaki(jmlKaki);
		cir.setNama(nama);
		assertThat(c.getJenis(), equalToIgnoringCase(cir.getJenis()));
		assertEquals(c.getUsia(), cir.getUsia());
		assertEquals(c.getJmlKaki(), cir.getJmlKaki());
		assertThat(c.getNama(), equalToIgnoringCase(cir.getNama()));
	}
	
	@ParameterizedTest
	@MethodSource("ciArray5")
	void testBergerak(Anjing c, String output) {
		assertEquals(c.bergerak(), output); 
	}
	@ParameterizedTest
	@MethodSource("ciArray6")
	void testMakan(Anjing d, String c, String h) {
		assertEquals(d.makan(c), h); 
	}
	
	@Test
	void testBersuara() {
		cir = new Anjing(1,"Anjing ABC",4,"ABC");
		assertEquals(cir.bersuara(), "Guk..guk..guk..");
	}
	@ParameterizedTest
	@MethodSource("ciArray7")
	void testToString(Anjing c, String s) {
		assertThat(c.toString(), containsString(s));
	}
	
	
}