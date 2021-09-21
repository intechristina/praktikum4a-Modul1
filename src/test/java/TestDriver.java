//TestDriver.java

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.*;
import java.io.*;


public class TestDriver {

	@Test
    public void testDriver()
    {
     PrintStream originalOut = System.out;
     ByteArrayOutputStream bos = new ByteArrayOutputStream();
     System.setOut(new PrintStream(bos));

     // action
	Driver.main(null);

     // assertion
     assertEquals("Nama: Balto, jenis: Anjing Huskies Siberia, usia: 3 tahun, jumlah kaki: 4\nNama: Heihei, jenis: Ayam kampoeng, usia: 1 tahun, jumlah kaki: 2\nNama: Garfield, jenis: Exotic Shorthair, usia: 3 tahun, jumlah kaki: 4, posisi (4,4)\nBalto bergerak dengan 4 kaki\nHeihei sedang mematuk biji-bijian\nGarfield bersuara Kukuruyukk..\nGarfield bergerak maju 10 langkah\nNama: Garfield, jenis: Exotic Shorthair, usia: 3 tahun, jumlah kaki: 4, posisi (4,14)\nGarfield bergerak dengan 4 kaki\n", bos.toString());

     // undo the binding in System
     System.setOut(originalOut);
   }
	
}