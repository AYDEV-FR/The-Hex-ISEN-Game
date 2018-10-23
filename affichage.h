
/*********************************************************************************
**  Affiche des codes Ansi afin que le texte qui suivra sera de la couleur voulue
**/
void TexteCouleur(int color, int underlined) {
	if (MODE_AFFICHAGE == 0) {
		if (underlined == 0) {
			printf("\033[1;3%dm", color);
		} else {
			printf("\033[4;3%dm", color);
		}
	}
}

/*********************************************************************************
**  Affiche des codes Ansi afin que le texte qui suivra sera 'normal'
**/
void TexteNormal(void) {
	if (MODE_AFFICHAGE == 0) {
		printf("\033[0m");
	}
}

/*********************************************************************************
**  Affiche des codes Ansi afin que le texte qui suivra sera souligné
**/
void TexteSouligne(void) {
	if (MODE_AFFICHAGE == 0) {
		printf("\033[4m");
	}
}

/*********************************************************************************
**  Affiche un texte entouré d'un cadre de '*' selon les couleurs voulues
**/
void AfficheCadre(char * chaine, int colortxt, int colorcadre) {
	int n = strlen(chaine), i;
	switch (MODE_AFFICHAGE) {
		case 0:
			printf("\033[1;3%dm", colorcadre);
			for (i=0; i<n+4; i++) { printf("*"); }
			printf("\n* \033[0m");
			AfficheChaine(chaine, colortxt, 0);
			printf("\033[1;3%dm *\n", colorcadre);
			for (i=0; i<n+4; i++) { printf("*"); }
			printf("\033[0m\n");
			break;
		case 1:
			for (i=0; i<n+4; i++) { printf("*"); }
			printf("\n* %s *\n", chaine);
			for (i=0; i<n+4; i++) { printf("*"); }
			printf("\n");
			break;
		case 2:
			for (i=0; i<n+4; i++) { printf("*"); }
			printf("\n* %s *\n", chaine);
			for (i=0; i<n+4; i++) { printf("*"); }
			printf("\n");
			break;
	}
}


/*********************************************************************************
**  Affiche une chaine colorisée
**/
void AfficheChaine(char * chaine, int color, int underlined) {
	switch (MODE_AFFICHAGE) {
		case 0:
			if (underlined == 0) {
				printf("\033[1;3%dm%s\033[0m", color, chaine);
			} else {
				printf("\033[1m\033[4;3%dm%s\033[0m\033[0m", color, chaine);
			}
			break;
		case 1:
			if (underlined == 0) {
				printf("%s", chaine);
			} else {
				printf("\033[4m%s\033[0m", chaine);
			}
			break;
		case 2:
			printf("%s", chaine);
			break;
	}
}

void AfficheChar(char caractere, int color, int underlined) {
	switch (MODE_AFFICHAGE) {
		case 0:
    if (underlined == 0) {
      printf("\033[1;3%dm%c\033[0m", color, caractere);
    } else {
      printf("\033[1m\033[4;3%dm%c\033[0m\033[0m", color, caractere);
    }
			break;
		default :
			printf("%c", caractere);
			break;
	}
}

/*********************************************************************************
**  Decalage
**/
void decalage(int decalage){
  for(int i = 0; i < DECALAGE_PLATEAU + decalage; i++) printf(" ");
}

/*********************************************************************************
**  Affiche Ligne
**/
void afficheLigne(int ligne[TAILLE_PLATEAU], int dec){
  decalage(dec);
  AfficheChar(65+dec, ANSI_ROUGE, False);
  AfficheChaine(" \\ ", ANSI_ROUGE, False);
  for (int i = 0; i < TAILLE_PLATEAU; i++) {
    printf("%d ", ligne[i]);
  }
  AfficheChaine("\\ \n", ANSI_ROUGE, False);
}

/*********************************************************************************
**  Affiche Plateau Complet
**/
void affichePlateau(int p[TAILLE_PLATEAU][TAILLE_PLATEAU]){
  decalage(2);
  for(int i=1; i <= TAILLE_PLATEAU; i++){
    TexteCouleur(ANSI_BLEU, True);
    printf("%d", i);
    TexteNormal();
    printf(" ");
  }
  printf("\n");
  for(int i = 0; i < TAILLE_PLATEAU; i++){
    afficheLigne(p[i], i);
  }
  decalage(TAILLE_PLATEAU + 2);
  AfficheChaine("------------------------ \n\n\n", ANSI_BLEU, False);
}
