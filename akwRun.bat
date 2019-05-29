@title AKW - Build and Run
@echo OFF

@set akwProjectName=akw-spring-boot-test
@set akwVersion=0.1.0

SET /P isBuild=Do you want me to build it for you (y/n)? 
SET /P isRun=Do you want me to run it for you (y/n)? 

:AKWBuild
if "%isBuild%"=="" GOTO :AKWRun
if "%isBuild%"=="n" GOTO :AKWRun
if "%isBuild%"=="N" GOTO :AKWRun

@echo.
@echo Now, build the application
call gradlew build
if errorlevel 1 (
	goto :AKWError
)

:AKWRun
if "%isRun%"=="" GOTO :AKWExit
if "%isRun%"=="n" GOTO :AKWExit
if "%isRun%"=="N" GOTO :AKWExit

@echo.
@echo Now, run the application
@java -jar build\libs\%akwProjectName%-%akwVersion%.jar
@goto :AKWExit

:AKWError
@echo An error occured
@pause

:AKWExit
@echo Exit...