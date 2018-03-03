import java.security.*;

class generate_seed {
  public static void main(String[] args) {

    long nanoT1;
    long nanoT2;
    float deltaT;
    float deltaT_ns;

    float num_bits;
    float throughput;

    int i;

    // number of random bytes to get for each call to generateSeed
    int num_bytes = 24; // default = 24 bytes

    // number of times to get 'num_bytes' bytes
    int num_loops = 1; // default = 1 time

    SecureRandom random = new SecureRandom();

    // set algorithm to be used from command line: NativePRNG or SHA1PRNG
    try {
      random = SecureRandom.getInstance(args[0]);
     } catch (NoSuchAlgorithmException ex) {
      System.out.println("Unabe to switch requested algorithm.");
      return;
     }

    // read num_bytes from command line
    try {
      num_bytes = Integer.parseInt(args[1]);
    } catch (ArrayIndexOutOfBoundsException e) {
    
    }

    // read num_loops from command line 
    try {
      num_loops = Integer.parseInt(args[2]);
    } catch (ArrayIndexOutOfBoundsException e) {
    
    }


    byte[] b = new byte[num_bytes];

    nanoT1 = System.nanoTime();

    for (i = 0; i < num_loops; i++)  
      b = random.generateSeed(num_bytes);

    nanoT2 = System.nanoTime();
    

    deltaT_ns = nanoT2 - nanoT1; // ns
    deltaT = deltaT_ns / 1_000_000_000; // s

    num_bits = num_bytes*num_loops*8; 

    throughput = num_bits / deltaT; // b/s
    throughput = throughput / 1_000_000; // Mbps
     
    System.out.println(deltaT_ns + " ns");
    System.out.printf("%f Mbps\n", throughput);
  }
}
