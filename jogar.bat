@echo off
chcp 65001 > nul
cd /d "%~dp0"
title RPG Console - A Masmorra do Dragao
echo Preparando o jogo...
if exist out rmdir /s /q out
javac -encoding UTF-8 -d out -sourcepath src src\rpg\Main.java
if errorlevel 1 (
  echo.
  echo Nao foi possivel compilar. Verifique se o JDK 17+ esta instalado: java -version
  pause
  exit /b 1
)
cls
java -Dstdout.encoding=UTF-8 -cp out rpg.Main %*
echo.
pause
