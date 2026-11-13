#!/usr/bin/env bash
# Compila e inicia o jogo com um único comando (ou duplo clique, se o sistema permitir).
cd "$(dirname "$0")"
rm -rf out
javac -encoding UTF-8 -d out -sourcepath src src/rpg/Main.java || { echo "Não foi possível compilar. Verifique o JDK 17+ (java -version)."; exit 1; }
clear
java -Dstdout.encoding=UTF-8 -cp out rpg.Main "$@"
