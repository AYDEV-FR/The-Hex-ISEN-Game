/*********************************************************************************
**  Prototypes   AFFICHAGE
**/
void AfficheChar(char caractere, int color, int underlined);
void AfficheChaine(char *, int, int);
void AfficheCadre(char * , int , int );

void TexteCouleur(int, int);
void TexteNormal(void);
void TexteSouligne();

void afficheLigne(int ligne[TAILLE_PLATEAU], int dec);
void affichePlateau(int plateau[TAILLE_PLATEAU][TAILLE_PLATEAU]);
void decalage(int decalage);
