# Simple Java Makefile (all files in same directory)

# Compiler and JVM settings
JAVAC = javac
JAVA = java
JFLAGS = -g
MAIN_CLASS = UseThreads 

# Get all .java files in current directory
SOURCES := $(wildcard *.java)
CLASSES := $(SOURCES:.java=.class)

.PHONY: all clean run

# Default target - compile all
all: $(CLASSES)

# Rule to compile .java files to .class files
%.class: %.java
	$(JAVAC) $(JFLAGS) $<

# Run the program
run: $(CLASSES)
	$(JAVA) $(MAIN_CLASS)

# Clean up compiled files
clean:
	rm -f *.class