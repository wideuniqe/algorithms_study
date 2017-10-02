build : main.o queue.o
	cc -o run.out main.o queue.o
	printf '======\n'
	./run.out
main.o : main.c queue.h
	cc -c main.c
kbd.o : queue.c queue.h
	cc -c queue.c
