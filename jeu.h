int Ascii(char c){
  return (int) c - 65;
}


void Ask_Joueur(int plateau[TAILLE_PLATEAU][TAILLE_PLATEAU], int n){
  char ligne;
  int l,c;
  do {
    n == 1 ? TexteCouleur(ANSI_ROUGE, True) : TexteCouleur(ANSI_BLEU, True);
    printf("Joueur %d \n", n);
    TexteNormal();
    printf("Déplacement (A 1) : ");
    scanf("%s %d", &ligne, &c);
    l = Ascii(ligne);
  } while(plateau[l][c-1] != 0);
  plateau[l][c-1] = n;
}


int findPath(int plateau[TAILLE_PLATEAU][TAILLE_PLATEAU], int x, int y, int n) {
    if(n == 1) plateau[x][y] = 3;
    if(n == 2) plateau[x][y] = 4;

    if (n == 1 && y == TAILLE_PLATEAU - 1) {
        return True;
    }
    if (n == 2 && x == TAILLE_PLATEAU - 1) {
        return True;
    }
    if (x + 1 < TAILLE_PLATEAU && plateau[x + 1][y] == n) {
        if (findPath(plateau, x + 1, y, n)) {
            return True;
        }
    }
    if (x - 1 >= 0 && plateau[x - 1][y] == n) {
        if (findPath(plateau, x - 1, y, n)) {
            return True;
        }
    }
    if (y + 1 < TAILLE_PLATEAU && plateau[x][y + 1] == n) {
        if (findPath(plateau, x, y + 1, n)) {
            return True;
        }
    }
    if (y - 1 >= 0 && plateau[x][y - 1] == n) {
        if (findPath(plateau, x, y - 1, n)) {
            return True;
        }
    }
    if (y - 1 >= 0 && x + 1 < TAILLE_PLATEAU && plateau[x + 1][y - 1] == n) {
        if (findPath(plateau, x + 1, y - 1, n)) {
            return True;
        }
    }
    if (y + 1 < TAILLE_PLATEAU && x - 1 >= 0 && plateau[x - 1][y + 1] == n) {
        if (findPath(plateau, x - 1, y + 1, n)) {
            return True;
        }
    }
    plateau[x][y] = n;
    return False;
}

int win(int plateau[TAILLE_PLATEAU][TAILLE_PLATEAU]){
  for (int i = 0; i < TAILLE_PLATEAU; i++) {
    if(plateau[i][0] == 1 && findPath(plateau, i, 0, 1)){
      return 1;
    }
  }
  for (int i = 0; i < TAILLE_PLATEAU; i++) {
    if(plateau[0][i] == 2 && findPath(plateau, 0, i, 2)){
      return 2;
    }
  }
  return 0;
}
