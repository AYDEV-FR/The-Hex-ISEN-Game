#include <stdlib.h>
#include <stdio.h>
#include <SDL/SDL.h>
#include <SDL/SDL_image.h>
#include "define.h"
#include "proto.h"
#include "screen.h"
#include "game.h"

// clear && gcc main.c `sdl-config --cflags --libs` -lSDL_image  && ./a.out


int main(int argc, char *argv[])
{
    SDL_Surface *ecran = NULL;
    Hex_Case **board;
    Hex jeu;
    jeu = initHex(11);

    SDL_Init(SDL_INIT_VIDEO);
    ecran = SDL_SetVideoMode(800, 600, 32, SDL_HWSURFACE);
    SDL_WM_SetCaption("The Hex'ISEN Game", NULL);
    SDL_FillRect(ecran, NULL, SDL_MapRGB(ecran->format, 255, 255, 255));

    updateBoard(jeu, ecran);

    SDL_Flip(ecran);

    int tour = 0;
    while(1){
      hexClick(jeu, (tour%2)+1);
      SDL_FillRect(ecran, NULL, SDL_MapRGB(ecran->format, 255, 255, 255));
      updateBoard(jeu, ecran);
      SDL_Flip(ecran);
      tour++;
    }


    SDL_Quit();
    return EXIT_SUCCESS;
}
