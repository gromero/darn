import java.security.*;
import java.nio.*;

class seed_darn {
  public static void main(String[] args) {

  SecureRandom random = new SecureRandom();

  ByteBuffer  bb = ByteBuffer.allocate(8);
  long random_number;

  final int total = 50;

  int i;
  for (i=0; i < total; i++) {
    random_number = random.darn();  
    bb.putLong(0, random_number);
    
    System.out.print("0x");

    int j;

    for (j = 0; j < 8; j++)
      System.out.format("%x", bb.array()[j]);

    System.out.println();
  }
 }
}
