

Hex initHex(int sizeTab){
  Hex hex;
  Hex_Case **board = initBoard(sizeTab);
  hex.board = board;
  hex.sizeBoard = sizeTab;
  return hex;
}


Hex_Case **initBoard(int n){
  Hex_Case **board;
  board = (Hex_Case**) malloc( n * sizeof(Hex_Case*));
  if( board == NULL ) {
    fprintf(stderr,"Allocation impossible");
    exit(EXIT_FAILURE);
  }
  for( int i = 0 ; i < n ; i++ ) {
    board[i] = (Hex_Case*) calloc (n, sizeof(Hex_Case));
    if( board[i] == NULL ) {
      fprintf(stderr,"Allocation impossible");
      exit(EXIT_FAILURE);
    }
  }
  for(int i=0; i < n; i++){
    for(int j=0; j < n; j++){
      board[i][j].pos.x = 0;
      board[i][j].pos.y = 0;
      board[i][j].hex = NULL;
      board[i][j].joueur = 0;
    }
  }
  return board;
}

void hexClick(Hex jeu, int n){
  SDL_Rect pos;
  do {
    pos = click(jeu);
  } while(jeu.board[pos.x][pos.y].joueur != 0);
  jeu.board[pos.x][pos.y].joueur = n;
  printf("%d %d\n", pos.x, pos.y);
}




int findPath(Hex hex, int x, int y, int n) {
    if(n == 1) hex.board[x][y].joueur = 3;
    if(n == 2) hex.board[x][y].joueur = 4;

    if (n == 1 && x == hex.sizeBoard - 1) {
        return True;
    }
    if (n == 2 && y == hex.sizeBoard - 1) {
        return True;
    }
    if (x + 1 < hex.sizeBoard && hex.board[x + 1][y].joueur == n) {
        if (findPath(hex, x + 1, y, n)) {
            return True;
        }
    }
    if (x - 1 >= 0 && hex.board[x - 1][y].joueur == n) {
        if (findPath(hex, x - 1, y, n)) {
            return True;
        }
    }
    if (y + 1 < hex.sizeBoard && hex.board[x][y + 1].joueur == n) {
        if (findPath(hex, x, y + 1, n)) {
            return True;
        }
    }
    if (y - 1 >= 0 && hex.board[x][y - 1].joueur == n) {
        if (findPath(hex, x, y - 1, n)) {
            return True;
        }
    }
    if (y - 1 >= 0 && x + 1 < hex.sizeBoard && hex.board[x + 1][y - 1].joueur == n) {
        if (findPath(hex, x + 1, y - 1, n)) {
            return True;
        }
    }
    if (y + 1 < hex.sizeBoard && x - 1 >= 0 && hex.board[x - 1][y + 1].joueur == n) {
        if (findPath(hex, x - 1, y + 1, n)) {
            return True;
        }
    }
    hex.board[x][y].joueur = n;
    return False;
}



int winHex(Hex hex){
  for (int i = 0; i < hex.sizeBoard; i++) {
    if(hex.board[0][i].joueur == 1 && findPath(hex, 0, i, 1)){
      return 1;
    }
  }
  for (int i = 0; i < hex.sizeBoard; i++) {
    printf("%d ", hex.board[i][0].joueur);
    if(hex.board[i][0].joueur == 2 && findPath(hex, i, 0, 2)){
      return 2;
    }
  }
  return 0;
}



/*
void freeHex(Hex hex){
  free(hex);
  hex = NULL;
}
*/
