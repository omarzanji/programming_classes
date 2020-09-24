#see README for a manual compilation process
#Source Code Header Files: open.h read.h print.h scheduler.h
#Source Code Implemenation Files: open.c read.c print.c scheduler.c
#Target binary file: scheduler
CC = gcc
CFLAGS = -g
OBJ = open.o read.o print.o

scheduler: $(OBJ) scheduler.c
	@echo "Creating the scheduler ..."
	$(CC) -o $@ $^ $(CFLAGS)

%.o: %.c %.h
	@echo "Creating object files ..."
	$(CC) -c $< -o $@

clean:
	@echo "Deleting object and binary files ..."
	rm -rvf *.o scheduler
