
SDL_Rect click(Hex jeu){
  int continuer = 1;
  SDL_Event event;
  SDL_Rect pos;

  while (continuer)
  {
      SDL_WaitEvent(&event);
      switch(event.type)
      {
        case SDL_QUIT:
              SDL_Quit();
              exit(0);
          case SDL_MOUSEBUTTONUP:
            for(int i=0; i < jeu.sizeBoard; i++){
              for(int j=0; j < jeu.sizeBoard; j++){
                if (event.button.button == SDL_BUTTON_LEFT
                    && event.button.x > jeu.board[i][j].pos.x
                    && event.button.x < jeu.board[i][j].pos.x + jeu.board[i][j].hex->w
                    && event.button.y > jeu.board[i][j].pos.y
                    && event.button.y < jeu.board[i][j].pos.y + jeu.board[i][j].hex->h){
                      pos.x = i;
                      pos.y = j;
                      return pos;
                    }
              }
            }
      }
  }
}


void updateBoard(Hex jeu, SDL_Surface *ecran){
  for(int i=0; i < 11; i++){
    for(int j=0; j < 11; j++){
      jeu.board[i][j].pos.x = SCREEN_SHIFT_H + 42*i + 21*j + 2*i;
      jeu.board[i][j].pos.y = SCREEN_SHIFT_V + 49*j - 11*j;
      switch (jeu.board[i][j].joueur) {
        case 0:
          jeu.board[i][j].hex = IMG_Load("img/Hex_Simple.png");
          break;
        case 1:
          jeu.board[i][j].hex = IMG_Load("img/Hex_Red.png");
          break;
        case 2:
          jeu.board[i][j].hex = IMG_Load("img/Hex_Blue.png");
          break;
        case 3: case 4:
        jeu.board[i][j].hex = IMG_Load("img/Hex_Ok.png");
        break;
      }
      SDL_BlitSurface(jeu.board[i][j].hex, NULL, ecran, &jeu.board[i][j].pos);
    }
  }
  displayContour(ecran);
}

void updateScreen(SDL_Surface *ecran){
  SDL_FillRect(ecran, NULL, SDL_MapRGB(ecran->format, 255, 255, 255));
  SDL_Flip(ecran);
}

void displayContour(SDL_Surface *ecran){
  SDL_Surface *contour;
  SDL_Rect pos;
  contour = IMG_Load("img/Hex_Contour.png");
  pos.x = SCREEN_SHIFT_H - 4;
  pos.y = SCREEN_SHIFT_V - 4;
  SDL_BlitSurface(contour, NULL, ecran, &pos);
}
