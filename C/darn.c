#include <sys/platform/ppc.h>
#include <stdio.h>
#include <stdlib.h>
#include <inttypes.h>

uint64_t get_random()
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

 int nb = 1*1024; /* default: 1KiB */
 int nl = 0;
 int i;

 double rate = 0;

 if (argc > 1)
	nb = atoi(argv[1])*1024;

 p = malloc(nb);
 
 nl = nb / 8; /* find out number of darn */

 nl++;

 t1 = __ppc_get_timebase();

 for (i =0; nl >= 1; nl--, i++)
   p[i] = get_random();

 t2 = __ppc_get_timebase();

 delta = t2 - t1;

 printf("%f Mbps\n", (((nb)*8)/(delta*0.000000001953125))/1000000);
}
