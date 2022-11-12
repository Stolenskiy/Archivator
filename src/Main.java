import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;


public class Main {
    public static void main( String[] args ) throws IOException {
        SSVArc arc = new SSVArc( "testFile" );
        arc.compress();
    }


}