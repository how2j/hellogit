#include <stdio.h>
#include <unistd.h>
#include <getopt.h>
#include <stdlib.h>

int main(int argc, char *argv[]){
    int start = 0;
    int end = 0;
    int sum = 0;
    int opt;
    char *optstring = ":s:e:";

    while((opt = getopt(argc, argv, optstring))!= -1){
        switch(opt){
            case 's': start = atoi(optarg); break;
            case 'e': end = atoi(optarg); break;
            case ':': puts("Missing parameter"); exit(1);
        }
    }
   
    if(start<0 || end<=start){
        puts("Parameter error"); exit(2);
    }
   
    for(int i=start; i<=end; i++){
        sum+=i;
    }
    printf("%d\n", sum);

    return 0;
}
