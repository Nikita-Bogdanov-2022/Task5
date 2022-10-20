@ECHO OFF
javac Reverse.java
javac MyScanner.java
javac WordStatWords.java
java -ea -jar FastReverseTest.jar Base
java -ea -jar WordStatTest.jar Words
PAUSE