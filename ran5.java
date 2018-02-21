import java.security.*;

class ran5 {
  public static void main(String[] args) {

    long nanoT1;
    long nanoT2;
    float delta;
    int i;

    byte[] b = new byte[20];
    SecureRandom random = new SecureRandom();

    nanoT1 = System.nanoTime();

    b = random.generateSeed(20);

    nanoT2 = System.nanoTime();

    delta = nanoT2 - nanoT1;

    System.out.println(delta + " ns");
  }
}
