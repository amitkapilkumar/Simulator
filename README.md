# Simulator
Toy Robot Simulator. input to simulator can be supplied via file.

## Execution command:
### java -cp ToyRobot-0.0.1-SNAPSHOT.jar com.runner.Main `filepath`
ex. 
> java -cp ToyRobot-0.0.1-SNAPSHOT.jar com.runner.Main C:\Users\amitk\eclipse-workspace\ToyRobot\testData\set-1.txt  

Above command will execute simulator on 5x5 dimnesion table, it's default dimension

> java -cp ToyRobot-0.0.1-SNAPSHOT.jar com.runner.Main C:\Users\amitk\eclipse-workspace\ToyRobot\testData\set-1.txt 6 8

Above command will execute simulator on 6x8 dimnesion table.

## Building through Maven
> `mvn clean install` under ToyRobot/ dir

## Test data
> testData/ folder holds 6 test data.

## Unit Test
> Junit along with Mockito is used to write Unit test cases present under test folder.
