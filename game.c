#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "define.h"
#include "prototypes.h"
#include "affichage.h"

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
  AfficheCadre("          The Hex'ISEN Game          ", ANSI_ROUGE, ANSI_BLEU);
  affichePlateau(plateau);
}
