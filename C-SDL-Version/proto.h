typedef struct {
  SDL_Surface *hex;
  SDL_Rect pos;
  int joueur;
} Hex_Case;

typedef struct {
  Hex_Case **board;
  int sizeBoard;
} Hex;

Hex initHex(int sizeTab);
Hex_Case **initBoard(int n);
void freeBoard(Hex_Case **board);
void hexClick(Hex jeu, int n);
int winHex(Hex hex);
int findPath(Hex hex, int x, int y, int n);

SDL_Rect click(Hex jeu);
void updateBoard(Hex jeu, SDL_Surface *ecran);
void updateScreen(SDL_Surface *ecran);
void displayContour(SDL_Surface *ecran);
