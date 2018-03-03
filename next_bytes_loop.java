import java.security.*;

class next_bytes_loop {
  public static void main(String[] args) {

    long nanoT1;
    long nanoT2;
    float deltaT;
    float rate;
    float bits;
    float num_bytes = 24;
    int i;

    byte[] b = new byte[24];

    SecureRandom random = new SecureRandom();

    nanoT1 = System.nanoTime();
    for (i = 1; i < 1024; i++) {
  
      random.nextBytes(b);

    }   
    nanoT2 = System.nanoTime();

    deltaT = nanoT2 - nanoT1; // ns
    deltaT = deltaT / 1000_000_000; // s
    bits = num_bytes*1024*8;
    rate = bits / deltaT; // b/s
    rate = rate / 1000000; // Mbps

    System.out.println(rate + " Mbps");
  }
}
