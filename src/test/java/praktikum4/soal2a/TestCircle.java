//TestCircle.java
package praktikum4.soal2a;

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
import praktikum4.soal2a.*;


public class TestCircle {

	Circle cir;

	static Stream<Arguments> ciArray() {
    return Stream.of(
        Arguments.of(new Point(10,10),5),
        Arguments.of(new Point(3,7),11),
		Arguments.of(new Point(10,2),4)
    );}
	static Stream<Arguments> ciArray2() {
    return Stream.of(
        Arguments.of(new Circle(new Point(10,10),5)),
        Arguments.of(new Circle(new Point(3,7),11)),
		Arguments.of(new Circle(new Point(10,2),4))
    );}
	
	static Stream<Arguments> ciArray3() {
    return Stream.of(
        Arguments.of(new Point(10,10),5,new Circle(new Point(10,10),5)),
        Arguments.of(new Point(3,7),11,new Circle(new Point(3,7),11)),
		Arguments.of(new Point(10,2),4,new Circle(new Point(10,2),4))
    );}
	
	static Stream<Arguments> ciArray4() {
    return Stream.of(
        Arguments.of(5),
        Arguments.of(20),
		Arguments.of(3)
    );}
	
	
	static Stream<Arguments> ciArray5() {
    return Stream.of(
        Arguments.of(new Circle(new Point(10,10),5), 19.625),
        Arguments.of(new Circle(new Point(3,7),11),94.985),
		Arguments.of(new Circle(new Point(10,2),4),12.56)
    );}
	
	static Stream<Arguments> ciArray6() {
    return Stream.of(
        Arguments.of(new Circle(new Point(10,10),5), 15.700000000000001),
        Arguments.of(new Circle(new Point(3,7),11),34.54),
		Arguments.of(new Circle(new Point(10,2),4),12.56),
		Arguments.of(new Circle(new Point(3,4),3),9.42)
    );}
	
	static Stream<Arguments> ciArray7() {
    return Stream.of(
        Arguments.of(new Circle(new Point(10,10),5),"\nCircle with :\n\tPoint : (10,10)\n\tDiameter  : 5\n\tLuas : 19.625\n\tKeliling : 15.700000000000001"),
        Arguments.of(new Circle(new Point(3,7),11),"\nCircle with :\n\tPoint : (3,7)\n\tDiameter  : 11\n\tLuas : 94.985\n\tKeliling : 34.54"),
		Arguments.of(new Circle(new Point(10,2),4),"\nCircle with :\n\tPoint : (10,2)\n\tDiameter  : 4\n\tLuas : 12.56\n\tKeliling : 12.56")
    );}
	
		
	@Test
	public void testKonstruktorI()
	{ 
		 cir = new Circle();
		 assertThat("circle", equalToIgnoringCase(cir.getName()));
		 assertEquals(new Point(), cir.getP());
		 assertEquals(1, cir.getDiameter());
		 assertEquals(3.14, cir.PI); 
	}
	
	@ParameterizedTest
	@MethodSource("ciArray")
	public void testKonstruktorII(Point p, int d) {
		cir = new Circle(p,d);
		assertThat("circle", equalToIgnoringCase(cir.getName()));
		 assertEquals(new Point(p), cir.getP());
		 assertEquals(d, cir.getDiameter());
		 assertEquals(3.14, cir.PI); 
	}
	@ParameterizedTest
	@MethodSource("ciArray2")
	public void testKopiKonstruktor(Circle c) {
		cir = new Circle(c);
		assertThat(c.getName(), equalToIgnoringCase(cir.getName()));
		assertEquals(c.getP(), cir.getP());
		assertEquals(c.getDiameter(), cir.getDiameter());
		assertEquals(c.PI, cir.PI); 
		assertNotSame(c,cir, "should not point to same Object");
		assertNotSame(c.getP(),cir.getP(), "should not point to same Object");
	}
	
	@ParameterizedTest
	@MethodSource("ciArray3")
	void testSetter(Point p, int d, Circle c) {
		cir = new Circle();
		cir.setP(p);
		cir.setDiameter(d);
		assertEquals(c, cir); 
	}
	
	@ParameterizedTest
	@MethodSource("ciArray4")
	void testSetDiameter(int d) {
		cir = new Circle();
		cir.setDiameter(d);
		assertEquals(d, cir.getDiameter()); 
	}
	@ParameterizedTest
	@MethodSource("ciArray5")
	void testGetArea(Circle c, double h) {
		assertEquals(h, c.getArea()); 
	}
	@ParameterizedTest
	@MethodSource("ciArray6")
	void testGetKeliling(Circle c, double h) {
		assertEquals(h, c.getCircumference()); 
	}
	@ParameterizedTest
	@MethodSource("ciArray7")
	void testToString(Circle c, String s) {
		assertThat(c.toString(), containsString(s));
	}
	
	
}