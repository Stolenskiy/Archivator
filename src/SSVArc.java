import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Arrays;


public class SSVArc {
    private InputStream fileStream;

    private BigInteger subtractor;

    private int countBytesInFile;

    private final int MAX_NUMBER_BYTES_FOR_SUBSTRACTOR = 1_000;


    public SSVArc( String fileName ) throws IOException {
        fileStream = this.getClass().getResourceAsStream( fileName );
        countBytesInFile = fileStream != null ? fileStream.available() : 0;
    }


    public void compress() throws IOException {
        byte[] partOfContent = fileStream.readNBytes( 55 );
        System.out.println( Arrays.toString( partOfContent ) );
        System.out.println(partOfContent.length  );
    }


    private void calculateSubstractor() {
        int byteCounter = 1;
        for( float i = countBytesInFile; i / 10 >= 1 && byteCounter != MAX_NUMBER_BYTES_FOR_SUBSTRACTOR; i /= 10 ) {
            byteCounter *= 10;
        }
        subtractor = new BigInteger( generateFilledBytes( byteCounter ) );
    }


    private byte[] generateFilledBytes( int count ) {
        byte[] bytes = new byte[count];
        for( int i = 0; i < count; i++ ) {
            bytes[i] = -128;
        }
        return bytes;
    }


}
