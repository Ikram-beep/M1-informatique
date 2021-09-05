#!/usr/bin/env python3
# -*- coding : utf-8 -*-

import sys, os, re, random

os.system("clear")

if len(sys.argv) > 1 and sys.argv[1].isdigit() :
   nbQuestions = int(sys.argv[1])
   fd = open("capitales.csv", "r")
   pays = []
   capitales = []
   for ligne in fd :
     resultat = re.search("^([^(]+).*,([^(]+)", ligne)
     if resultat :
        pays.append(resultat.group(1))
        capitales.append(resultat.group(2)[:-1])
     # On aurait pu bien sûr utiliser split() :
     #data = ligne.split(",")
     #if len(data) > 1 :
     #   pays.append(data[0])
     #   capitales.append(data[1][:-1])
     
   score = 0
   numQuestion = 0
   while numQuestion < nbQuestions :
     numPays = random.randint(0, len(pays)-1)
     reponse = input("\nCapitale de "+pays[numPays]+" ? ")
     if reponse == capitales[numPays] :
        print("Bonne réponse ("+capitales[numPays]+")")
        score += 1
     else :
        print("La bonne réponse était", capitales[numPays])
     numQuestion += 1
     del pays[numPays];
     del capitales[numPays];    

   print("\nVotre score est", score, "soit", score/nbQuestions*100, "%")
else :
   print("Mauvais usage du script : un nombre de questions doit être donné en paramètre !")   
