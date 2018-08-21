#!/bin/sh

BASE_DIR=/home/mrson/NewpostJava
BATCH_HOME=$BASE_DIR/NewpostBatch
MAIN_CLASS_JAVA=$BATCH_HOME/printPDF/VibloPdf.java
TAGET_CLASS=$BATCH_HOME/target/classes

#FUNCTION
function setClassPathDefault(){
    CLASSPATH="$BATCH_HOME:$TAGET_CLASS";
}

function add()
{
    LIB_PATH="$LIB_PATH:$1"
}

function setClassPath(){
    CLASSPATH="$CLASSPATH:$1";
}
#FUNCTION

#setDeafault
setClassPathDefault;

#set lib
for i in $BATCH_HOME/lib/*.jar
do
    add $i;
done

for i in $BATCH_HOME/lib/*.zip
do
    add $i;
done


# set lib path into classpath
setClassPath $LIB_PATH;

export classpath=$CLASSPATH;

javac -cp $classpath $MAIN_CLASS_JAVA -d $TAGET_CLASS
java  -cp $classpath printPDF.VibloPdf




