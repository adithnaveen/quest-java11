dir /S /B src\*.java > src.txt 

javac --module-source-path src -d out @src.txt