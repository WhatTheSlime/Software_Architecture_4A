package fr.esiea;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest
{
    @Test
    public void HelloWorldTest(){
        App app = new App();

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        app.main(null);
        Assertions.assertThat(outContent.toString()).isEqualTo("Hello World!" + System.getProperty("line.separator"));
        System.setOut(null);
    }
}
