#include <sys/platform/ppc.h>
#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>

uint8_t* generate_seed(int numbytes)
{

}

uint64_t try_darn()
{
 uint64_t r;	

 asm (
     "darn %[r], 2;"
     : [r] "=r" (r)
     :
     :
     );

 return r;
}

int main(int argc, char **argv)
{
 uint64_t random_number;

 uint64_t t1;
 uint64_t t2; 
 uint64_t delta;
 uint64_t *p;
 uint8_t *pp;
 int nb = 1*1024;
 int nl = 0;
 int offset = 0;
 int i;
 double rate = 0;
 if (argc > 1)
	nb = atoi(argv[1])*1024;

// printf("n = %d random bytes\n", nb);

 p = malloc(nb);
 
 nl = nb / 8;

 nl++;

 t1 = __ppc_get_timebase();

 for (i =0; nl >= 1; nl--, i++)
   p[i] = try_darn();

 t2 = __ppc_get_timebase();

 delta = t2 - t1;

 pp = (uint8_t *) p;

// for (i = 0; i < nb; i++)
//   printf("%02x", pp[i]);

// printf("\n");

 // printf("%p\n",(void *) p[0]);

// printf("freq= %lx\n", __ppc_get_timebase_freq());
   printf("%f\n", (nb/1024)/(delta*0.000000001953125));

//  printf("%f KiB/s\n", nb/(delta*));
}
