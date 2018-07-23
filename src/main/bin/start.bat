@echo off

REM #
REM # $RCSfile$
REM # $Revision: 1102 $
REM # $Date: 2005-03-07 22:36:48 -0300 (Mon, 07 Mar 2005) $
REM #

if "%JAVA_HOME%" == "" goto javaerror
if not exist "%JAVA_HOME%\bin\java.exe" goto javaerror
goto run

:javaerror
echo.
echo Error: JAVA_HOME environment variable not set, server not started.
echo.
goto end

:run
if "%1" == "-debug" goto debug
start "server" "%JAVA_HOME%\bin\java" -server -XX:PermSize=128M -XX:MaxPermSize=256M -Xms1024M -Xmx1024M -classpath "..\conf" -Djava.ext.dirs=..\lib com.yc.sandfactory.Starter
goto end

:end