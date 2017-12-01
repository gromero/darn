import java.security.*;

class darning {
  public static void main(String[] args) {

  SecureRandom random = new SecureRandom();

  int j = 0;
  byte[] b = new byte[8];

  b = random.darn();  

  for (j = 0; j < 8; j++)
    System.out.format("%x\n", b[j]); 
  }
}
