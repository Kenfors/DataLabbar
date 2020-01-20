#include <stdio.h>



/*
XXXX XXXX . XXXX XXXX
PAGE O  F  F  S  E  T
4bit   12bit

*/

#define PAGESIZE 256
#define VMEMSIZE 8*PAGESIZE
#define PHYSSIZE 2*VMEMSIZE

#define TLBSIZE 4
typedef struct  {
    unsigned int vpn    :3;
    unsigned int pfn    :4;
    unsigned int v      :1;
} TLB;


typedef struct  {
    unsigned int valid      :1;
    unsigned int present    :1;
    unsigned int accessed   :1;
    unsigned int dirty      :1;
    unsigned int prot       :3;
    union 
    {
        unsigned int pfn    :4;
        unsigned int ssd    :5;
    };
    

} pageEntry;


void initValidPTE(pageEntry * PageTable, unsigned short pfn){
    PageTable->valid = 1;
    PageTable->present = 1;
    PageTable->dirty = 0;
    PageTable->accessed = 0;
    PageTable->pfn = pfn;

}

void clearValidPTE(pageEntry * PageTable){
    PageTable->valid = 0;
}

int nextFreeFrame(unsigned int * PFT){

    while(*PFT){
        *PFT<<1;
        if (!(*PFT & 2^16 > 0)) {
            return *PFT;
        }
    }
    return -1;
}


int main(void){
    pageEntry PageTable[VMEMSIZE/PAGESIZE];
    printf("MMU 0.1\n");

    






    printf("MMU DONE!\n");
    return 0;
}