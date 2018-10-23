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
    printf("Veuillez entrer la case ou placer le pion (A1, A2, ... B1, B2...) : ");
    scanf("%s %d", &ligne, &c);
    l = Ascii(ligne);
  } while(plateau[l][c-1] != 0);
  plateau[l][c-1] = n;
}
