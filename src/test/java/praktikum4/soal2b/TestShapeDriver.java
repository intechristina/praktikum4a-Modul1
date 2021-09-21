//TestShapeDriver.java
package praktikum4.soal2b;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import praktikum4.soal2a.*; 

public class TestShapeDriver {
	
	static Stream<Arguments> ciArray7() {
    return Stream.of(
        Arguments.of(new Circle(new Point(10,10),5),"\nCircle with :\n\tPoint : (10,10)\n\tDiameter  : 5\n\tLuas : 19.625\n\tKeliling : 15.700000000000001"),
        Arguments.of(new Circle(new Point(3,7),11),"\nCircle with :\n\tPoint : (3,7)\n\tDiameter  : 11\n\tLuas : 94.985\n\tKeliling : 34.54"),
		Arguments.of(new Circle(new Point(10,2),4),"\nCircle with :\n\tPoint : (10,2)\n\tDiameter  : 4\n\tLuas : 12.56\n\tKeliling : 12.56")
    );}
	
	static Stream<Arguments> recArray8() {
    return Stream.of(
        Arguments.of(new Rectangle(new Point(10,10),new Point(3,3)),"\nRectangle with :\n\tPoint P1: (10,10)\n\tPoint P2: (3,3)\n\twidth : 7\n\theight : 7\n\tLuas : 49.0\n\tKeliling : 28.0"),
        Arguments.of(new Rectangle(new Point(3,7),new Point(9,12)),"\nRectangle with :\n\tPoint P1: (3,7)\n\tPoint P2: (9,12)\n\twidth : 6\n\theight : 5\n\tLuas : 30.0\n\tKeliling : 22.0"),
		Arguments.of(new Rectangle(new Point(10,2),new Point(1,1)),"\nRectangle with :\n\tPoint P1: (10,2)\n\tPoint P2: (1,1)\n\twidth : 9\n\theight : 1\n\tLuas : 9.0\n\tKeliling : 20.0")
    );}
	
	@ParameterizedTest
	@MethodSource("recArray8")
	void testCreateRectangle(Rectangle r, String s) {
		assertThat(r.toString(), containsString(s));
	}
	
    @ParameterizedTest
	@MethodSource("ciArray7")
	void testCreateCircle(Circle c, String s) {
		assertThat(c.toString(), containsString(s));
	}
	
}