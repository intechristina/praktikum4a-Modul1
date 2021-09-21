//TestShape.java
package praktikum4.soal2a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;
import praktikum4.soal2b.*;


public class TestShape {

	Shape sha ;

	@ParameterizedTest
	@CsvSource(value = {"circle", "rectangle","triangle"})
	void testKonstrukturDenganParameter(String input) {
		sha = new Shape (input);
		assertNotNull(sha);
		assertThat(sha.getName(), equalToIgnoringCase(input));
	}
	@ParameterizedTest
	@CsvSource(value = {"circle", "rectangle","triangle"})
	void testSetName(String input) {
		sha = new Shape (input);
		Shape sha2 =new Shape("");
		sha2.setName(input);
		assertEquals(sha, sha2);
	}
	
}