make-cpp: run-java
	g++ ExampleCPP.hpp

run-java: make-java
	java -classpath out/production/TP5 main.Main example.Example ExampleCPP --stdout

make-java:
	javac src/example/Example.java src/converter/Writer.java src/converter/Fetcher.java src/main/Main.java

clean:
	rm -rf *.o
	rm -rf *.class