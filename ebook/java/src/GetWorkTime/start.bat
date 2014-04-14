@echo off

rem set your javahome
set JAVA_HOME=C:\Program Files (x86)\Java\jdk1.7.0_40


set PATH=%JAVA_HOME%/bin
set CLASSPATH=%JAVA_HOME%/lib/tools.jar;
java -jar run.jar
pause