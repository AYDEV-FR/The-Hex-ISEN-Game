/*********************************************************************************
 *                             PARAMETRES MODIFIABLES                            */
/*********************************************************************************
**  Nettoyage du terminal
**     CLEAR_ACTIVE  : active ou non le fait de nettoyer le terminal
**     CLEAR_COMMAND : commande de nettoyage ("clear" sous Nux, "cls" sous Windows)
**/
#define CLEAR_ACTIVE 1
#define CLEAR_COMMAND "clear"

/*********************************************************************************
**  MODE_AFFICHAGE
**     0 => Couleur [ANSI]
**     1 => noir et blanc (terminal default), à mettre pour windows...
**/
#define MODE_AFFICHAGE 0

/*********************************************************************************
**  nombre d'espaces ' ' à gauche du plateau
**/
#define DECALAGE_PLATEAU 5
#define TAILLE_PLATEAU 11

/*********************************************************************************
**  MODE_DEBUG
**     0 => pas d'affichage pour débugage
**
   1 => affichage débugage
**/
#define MODE_DEBUG 0

/*********************************************************************************
 *                                   CONSTANTES                                  */
/*********************************************************************************
*/
#define True 1
#define False 0

/*********************************************************************************
**  Codes ANSI pour les couleurs
**     Chiffre x dans [x;
**        0 => couleur foncee
**        1 => couleur claire
**        4 => souligné
**/
#define ANSI_NOIR    0
#define ANSI_ROUGE   1
#define ANSI_VERT    2
#define ANSI_JAUNE   3
#define ANSI_BLEU    4
#define ANSI_VIOLET  5
#define ANSI_CYAN    6
#define ANSI_BLANC   7
