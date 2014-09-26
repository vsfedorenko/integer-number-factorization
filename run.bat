@ECHO OFF
ECHO "Integer numbers factorization"
XCOPY input.txt factorization-app/target/input.txt /m /e /y
java -jar factorization-app/target/factorization-app-1.0-SNAPSHOT.jar
XCOPY factorization-app/target/output.txt output.txt /m /e /y
ECHO "DONE"