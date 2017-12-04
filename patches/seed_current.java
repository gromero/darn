import java.security.*;

class seed_current {
  public static void main(String[] args) {

    SecureRandom random = new SecureRandom();
    byte seeds[] = new byte[8];
    long total = 50;
    int i = 0;
    int j = 0;

    for (i = 1; i <= total; i++) {

      seeds = random.generateSeed(8);

      System.out.print("0x");

      for (j = 0; j < 8; j++)
        System.out.format("%x", seeds[j]);

      System.out.println();
    }
  }
}
