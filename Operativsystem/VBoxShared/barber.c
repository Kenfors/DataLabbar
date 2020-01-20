
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define WTIME 60*8      // Shop open 8h
#define ETIME 60*7      // No new customers last hour
#define SCALE 8         // 1 minute is 1/SCALE second

int delta(float lambda) {
    // Knuth imp of poisson process with extream value truncation
	return (int)(-log(((rand()/1.5f)/RAND_MAX)+0.20f)/lambda);
};

int main(void){
    int at=0, wait, id=0;
    printf("Barber shop simulation 0.1 AC\n");

    // Init needed concurrency features...

    // Create the barber!

    srand((unsigned)time(NULL));

    do {
       wait=delta(1/20.0f); at+=wait;
       sleep(wait/SCALE);
       printf("%02d:%02d !!! New customer #%02d enters shop... \n", at/60, at%60, id++);
       // Create new customer
    } while (at<ETIME);         // No more customers (roughly) last hour!

    sleep((WTIME-at)/SCALE);    // Barber works on remaining customers...

    printf("Barber shop simulation done!\n");
	return 0;
};
