# Text-File-Info

Pre-requistites
----------------
- Java SE Development Kit 8+
- Maven (build automation tool)

Building/Running
-----------------
1. Ensure that both the JDK's and Maven's bin directories are in your system's PATH variable.
2. Open a shell in this project's root directory (directory containing pom.xml) and run the "mvn package" command. This will compile/package all source files into a JAR file in the [project root]/target directory.
3. Execute the JAR file, passing the path to the desired text file as an optional argument. This can be done by opening a shell in the [project root]/target directory and running the "java -jar textfileinfo-1.0.0.jar [text file path]" command. If the path argument is not specified, then you will be prompted to enter a path upon execution.
4. Enjoy!

Heuristics
-----------
The content of the provided text file is split up into words, sentences, and paragraphs using the following patterns for delimiters. Each of the words, sentences, and paragraphs are then stored into their respective arrays, and the size of the arrays are then printed to the user's console.

Word Pattern: Alphanumeric + Zero-To-Many Characters + One-To-Many Spaces

Sentence Pattern 1: Alphanumeric + Zero-To-Many Characters + One-To-Many . (Period) Or ! (Exclamation) Or ? (Question) Or : (Colon) + Zero-To-Many ' (Single-Quote) Or " (Double-Quote) + One-To-Many Spaces

Sentence Pattern 2: Alphanumeric + Zero-To-Many Characters + One-To-Many LineBreaks

Paragraph Pattern: Alphanumeric + Zero-To-Many Characters + Two-To-Many LineBreaks
