

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
  for(int i=0; i < 11; i++){
    for(int j=0; j < 11; j++){
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
  pos = click(jeu);
  jeu.board[pos.x][pos.y].joueur = n;
}


/*
void freeHex(Hex hex){
  free(hex);
  hex = NULL;
}
*/
