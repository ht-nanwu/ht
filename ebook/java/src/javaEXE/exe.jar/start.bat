@echo off

rem set your javahome
set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_45


set PATH=%JAVA_HOME%/bin
set CLASSPATH=%JAVA_HOME%/lib/tools.jar;
java -jar exe.jar %~dp0
pause