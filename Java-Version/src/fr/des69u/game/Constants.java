package fr.des69u.game;

public class Constants {

	public static final int SIZE = 11;
	public static final int EMPTY = 0;
	public static final int BLUE = 2;
	public static final int WIN_BLUE = 4;
	public static final int RED = 1;
	public static final int WIN_RED = 3;
	
	public static final int OFFSET_X() {
		if(Settings.Size == 11) return 33;
		else return 95;
	}
	public static final int OFFSET_Y() {
		if(Settings.Size == 11) return 35;
		else return 35;
	}
	
	public static final int GAMEMODE_IA = 1;
	public static final int GAMEMODE_1V1 = 0;
	
	public static final String VERSION_NAME = "Alpha";
	public static final double VERSION = 3.1;
}
