#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "define.h"
#include "prototypes.h"
#include "affichage.h"
#include "jeu.h"

int plateau[TAILLE_PLATEAU][TAILLE_PLATEAU] = {
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0,0,0,0,0}
};

void main(){
  int tour = 0;
  while(win(plateau) == 0){
    AfficheCadre("          The Hex'ISEN Game          ", ANSI_ROUGE, ANSI_BLEU);
    affichePlateau(plateau);
    Ask_Joueur(plateau, tour%2+1);
    ClearScreen();
    tour++;
  }
  AfficheCadre("          The Hex'ISEN Game          ", ANSI_ROUGE, ANSI_BLEU);
  affichePlateau(plateau);
  AfficheChaine("Partie terminée ! \n\n\n", ANSI_ROUGE, True);
}
