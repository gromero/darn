import java.security.*;

class ran3 {
  public static void main(String[] args) {

    long nanoT1;
    long nanoT2;
    float rate;
    int i;

    byte[] b = new byte[20];
    SecureRandom random = new SecureRandom();

    nanoT1 = System.nanoTime();

    random.nextBytes(b);

    nanoT2 = System.nanoTime();

    rate = nanoT2 - nanoT1;
    rate = rate / 1000000000;
    rate = 20 / rate;

    System.out.println(rate + " B/s");
  }
}
