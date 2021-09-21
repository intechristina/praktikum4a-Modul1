//TestAyam.java

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


public class TestAyam {

	Ayam cir;

	
	static Stream<Arguments> ciArray3() {
    return Stream.of(
        Arguments.of(1,"Ayam ABC",4,"ABC", new Ayam(1,"Ayam ABC",4,"ABC")),
        Arguments.of(2,"Ayam DEF",3,"DEF", new Ayam (2,"Ayam DEF",3,"DEF")),
		Arguments.of(5,"Ayam GEF",4,"GEF", new Ayam (5,"Ayam GEF",4,"GEF"))
    );}
	
	static Stream<Arguments> ciArray4() {
    return Stream.of(
        Arguments.of(1,"Ayam ABC",4,"ABC", new Ayam(1,"Ayam ABC",4,"ABC")),
        Arguments.of(2,"Ayam DEF",3,"DEF", new Ayam (2,"Ayam DEF",3,"DEF")),
		Arguments.of(5,"Ayam GEF",4,"GEF", new Ayam (5,"Ayam GEF",4,"GEF"))
    );}
	
	
		static Stream<Arguments> ciArray5() {
    return Stream.of(
        Arguments.of(new Ayam(1,"Ayam ABC",4,"ABC"),"bergerak dengan 4 kaki"),
        Arguments.of(new Ayam (2,"Ayam DEF",3,"DEF"),"bergerak dengan 3 kaki"),
		Arguments.of(new Ayam (5,"Ayam GEF",1,"GEF"), "bergerak dengan 1 kaki")
    );}
	
	static Stream<Arguments> ciArray6() {
    return Stream.of(
        Arguments.of(new Ayam(1,"Ayam ABC",4,"ABC"),"daging", "sedang mematuk daging"),
        Arguments.of(new Ayam (2,"Ayam DEF",3,"DEF"),"tulang","sedang mematuk tulang"),
		Arguments.of(new Ayam (5,"Ayam GEF",1,"GEF"),"biji bijian","sedang mematuk biji bijian")
    );}
	
	static Stream<Arguments> ciArray7() {
    return Stream.of(
        Arguments.of(new Ayam(1,"Ayam ABC",4,"ABC"),"Nama: ABC, jenis: Ayam ABC, usia: 1 tahun, jumlah kaki: 4"),
        Arguments.of(new Ayam (2,"Ayam DEF",3,"DEF"),"Nama: DEF, jenis: Ayam DEF, usia: 2 tahun, jumlah kaki: 3"),
		Arguments.of(new Ayam (5,"Ayam GEF",1,"GEF"),"Nama: GEF, jenis: Ayam GEF, usia: 5 tahun, jumlah kaki: 1")
    );}
	
	@ParameterizedTest
	@MethodSource("ciArray3")
	public void testKonstruktor(int usia,String jenis,int jmlKaki,String nama, Ayam c) {
		cir = new Ayam(usia, jenis, jmlKaki, nama);
		assertThat(c.getJenis(), equalToIgnoringCase(cir.getJenis()));
		assertEquals(c.getUsia(), cir.getUsia());
		assertEquals(c.getJmlKaki(), cir.getJmlKaki());
		assertThat(c.getNama(), equalToIgnoringCase(cir.getNama()));
	}
	
	@ParameterizedTest
	@MethodSource("ciArray4")
	void testSetter(int usia,String jenis,int jmlKaki,String nama, Ayam c) {
		cir = new Ayam(5,"Ayam GEF",1,"GEF");
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
	void testBergerak(Ayam c, String output) {
		assertEquals(c.bergerak(), output); 
	}
	@ParameterizedTest
	@MethodSource("ciArray6")
	void testMakan(Ayam d, String c, String h) {
		assertEquals(d.makan(c), h); 
	}
	
	@Test
	void testBersuara() {
		cir = new Ayam(1,"Ayam ABC",4,"ABC");
		assertEquals(cir.bersuara(), "Kukuruyukk..");
	}
	@ParameterizedTest
	@MethodSource("ciArray7")
	void testToString(Ayam c, String s) {
		assertThat(c.toString(), containsString(s));
	}
	
	
}