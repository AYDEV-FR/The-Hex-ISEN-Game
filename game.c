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
  int game_over = False;
  int tour = 0;
  while(!game_over){
    AfficheCadre("          The Hex'ISEN Game          ", ANSI_ROUGE, ANSI_BLEU);
    affichePlateau(plateau);
    Ask_Joueur(plateau, (tour%2)+1);
    ClearScreen();
    tour++;
  }
}
