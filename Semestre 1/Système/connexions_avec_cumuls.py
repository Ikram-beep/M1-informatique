#!/usr/bin/env python3
#_*_ coding:UTF-8 _*_

import os, sys, re

connexions = {}
fd = os.popen ('last')
# Attention l'expression reguliere ci-dessous qui extrait :
# le login (tous les caracteres qui ne sont pas des espaces depuis le debut de la ligne)
# la date (une majuscule suivie de deux ou trois caracteres (Oct ou Oct.) et un nombre)
# les heures et minutes de connexion
# peut varier suivant le format de sortie de la commande last
expr = re.compile("^([^ ]+).+[A-Z].. +([A-Z][a-z]{2,3} +\d+).*(\d\d):(\d\d)\)")

for ligne in fd.readlines() :
    resultat = re.search (expr, ligne)
    if resultat :
        login   = resultat.group(1)
        date    = resultat.group(2)
        heures  = resultat.group(3)
        minutes = resultat.group(4)
        duree = int(heures)*60 + int(minutes)
        if login in connexions :
            if date in connexions[login] :
                nv_nb_connex = connexions[login][date][0] + 1
                nv_duree = connexions[login][date][1] + duree
                connexions[login][date] = [nv_nb_connex, nv_duree]
            else :
                connexions[login][date] = [1, duree]
        else :
            connexions[login] = {}
            connexions[login][date] = [1, duree]

fd.close()

logins = list(connexions.keys())
logins.sort()
for login in logins :
    print(login, "s'est connecte les")
    for date in connexions[login] :
        heures  = connexions[login][date][1] // 60
        minutes = connexions[login][date][1] % 60
        print("\t", date, ":", connexions[login][date][0], "fois ("+str(heures)+":"+str(minutes)+")")
