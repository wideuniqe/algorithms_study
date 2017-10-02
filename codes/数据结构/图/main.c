#include<stdio.h>
#include "queue.h"
#include <stdlib.h>  
#include <string.h>

int main(int argc,char* argv[]){
	
	queue_t q=queue_create();
	for(int i=0;i<argc;i++){
		char *p;  
		p=queue_enqueue(q, strlen(argv[i])+1);
		strcpy(p,argv[i]);
	}
	char* s=NULL;
	while((s=queue_dequeue(q))!=NULL){
		printf("s=%s\n",s);
		free(s);
	}
	queue_destroy(q);
	return 0;
}


