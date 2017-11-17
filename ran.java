import java.security.*;

class ran {
  public static void main(String[] args) {

    SecureRandom random = new SecureRandom();
    int i = 0;
    byte seeds[] = new byte[20];

    System.out.println(random.getAlgorithm());

    for (i = 1; i < 10; i++) {
  
      System.out.print("Generating " +  i +  " seed(s): ");

      seeds = random.generateSeed(i);

      System.out.println(seeds.length);
    }
  }
}
