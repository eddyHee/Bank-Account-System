JFLAGS = -d out -cp out
JC = javac
SRC = src/Main.java src/**/*.java  # Removed standalone src/

all:
	mkdir -p out
	$(JC) $(JFLAGS) $(SRC)

run:
	java -cp out Main

clean:
	rm -rf out