//TestRectangle.java
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


public class TestRectangle {

	Rectangle rec;
	
	static Stream<Arguments> recArray() {
    return Stream.of(
        Arguments.of(new Point(10,10),new Point(3,3)),
        Arguments.of(new Point(3,7),new Point(9,12)),
		Arguments.of(new Point(10,2),new Point(1,1))
    );}
	static Stream<Arguments> recArray2() {
    return Stream.of(
        Arguments.of(new Rectangle(new Point(10,10),new Point(3,3))),
        Arguments.of(new Rectangle(new Point(3,7),new Point(9,12))),
		Arguments.of(new Rectangle(new Point(10,2),new Point(1,1)))
    );}
	
	static Stream<Arguments> recArray3() {
    return Stream.of(
        Arguments.of(new Point(10,10),new Point(3,3),new Rectangle(new Point(10,10),new Point(3,3))),
        Arguments.of(new Point(3,7),new Point(9,12),new Rectangle(new Point(3,7),new Point(9,12))),
		Arguments.of(new Point(10,2),new Point(1,1),new Rectangle(new Point(10,2),new Point(1,1)))
    );}
	
	static Stream<Arguments> recArray4() {
    return Stream.of(
        Arguments.of(new Rectangle(new Point(10,10),new Point(3,3)),7 ),
        Arguments.of(new Rectangle(new Point(3,7),new Point(9,12)),6),
		Arguments.of(new Rectangle(new Point(10,2),new Point(1,1)),9)
    );}
	
	static Stream<Arguments> recArray5() {
    return Stream.of(
        Arguments.of(new Rectangle(new Point(10,10),new Point(3,3)),7 ),
        Arguments.of(new Rectangle(new Point(3,7),new Point(9,12)),5),
		Arguments.of(new Rectangle(new Point(10,2),new Point(1,1)),1)
    );}
	
	
	static Stream<Arguments> recArray6() {
    return Stream.of(
         Arguments.of(new Rectangle(new Point(10,10),new Point(3,3)),49.0 ),
        Arguments.of(new Rectangle(new Point(3,7),new Point(9,12)),30.0),
		Arguments.of(new Rectangle(new Point(10,2),new Point(1,1)),9.0)
    );}
	
	static Stream<Arguments> recArray7() {
    return Stream.of(
         Arguments.of(new Rectangle(new Point(10,10),new Point(3,3)),28.0 ),
        Arguments.of(new Rectangle(new Point(3,7),new Point(9,12)),22.0),
		Arguments.of(new Rectangle(new Point(10,2),new Point(1,1)),20.0)
    );}
	
	static Stream<Arguments> recArray8() {
    return Stream.of(
        Arguments.of(new Rectangle(new Point(10,10),new Point(3,3)),"\nRectangle with :\n\tPoint P1: (10,10)\n\tPoint P2: (3,3)\n\twidth : 7\n\theight : 7\n\tLuas : 49.0\n\tKeliling : 28.0"),
        Arguments.of(new Rectangle(new Point(3,7),new Point(9,12)),"\nRectangle with :\n\tPoint P1: (3,7)\n\tPoint P2: (9,12)\n\twidth : 6\n\theight : 5\n\tLuas : 30.0\n\tKeliling : 22.0"),
		Arguments.of(new Rectangle(new Point(10,2),new Point(1,1)),"\nRectangle with :\n\tPoint P1: (10,2)\n\tPoint P2: (1,1)\n\twidth : 9\n\theight : 1\n\tLuas : 9.0\n\tKeliling : 20.0")
    );}
	
		
	@Test
	public void testKonstruktorI()
	{ 
		 rec = new Rectangle();
		 assertThat("Rectangle", equalToIgnoringCase(rec.getName()));
		 assertEquals(new Point(), rec.getP1());
		 assertEquals(new Point(), rec.getP2());
	}
	
	@ParameterizedTest
	@MethodSource("recArray")
	public void testKonstruktorII(Point p1, Point p2) {
		rec = new Rectangle(p1,p2);
		 assertThat("Rectangle", equalToIgnoringCase(rec.getName()));
		 assertEquals(new Point(p1), rec.getP1());
		 assertEquals(new Point(p2), rec.getP2());
	}
	@ParameterizedTest
	@MethodSource("recArray2")
	public void testKopiKonstruktor(Rectangle r) {
		rec = new Rectangle(r);
		assertThat(r.getName(), equalToIgnoringCase(rec.getName()));
		assertEquals(r.getP1(), rec.getP1());
		assertEquals(r.getP2(), rec.getP2());
		assertNotSame(r,rec, "should not point to same Object");
	}
	
	@ParameterizedTest
	@MethodSource("recArray3")
	void testSetter(Point p1, Point p2, Rectangle r) {
		rec = new Rectangle();
		rec.setP1(p1);
		rec.setP2(p2);
		assertEquals(r, rec); 
	}
	
	@ParameterizedTest
	@MethodSource("recArray4")
	void tesGetWidth(Rectangle r, int w) {
		assertEquals(w, r.getWidth()); 
	}
	@ParameterizedTest
	@MethodSource("recArray5")
	void testGetHeight(Rectangle r, int h) {
		assertEquals(h, r.getHeight()); 
	}
	
	@ParameterizedTest
	@MethodSource("recArray6")
	void testGetArea(Rectangle r, double l) {
		assertEquals(l, r.getArea()); 
	}
	@ParameterizedTest
	@MethodSource("recArray7")
	void testGetKeliling(Rectangle r, double k) {
		assertEquals(k, r.getCircumference()); 
	}
	
	@ParameterizedTest
	@MethodSource("recArray8")
	void testToString(Rectangle r, String s) {
		assertThat(r.toString(), containsString(s));
	}
	
}