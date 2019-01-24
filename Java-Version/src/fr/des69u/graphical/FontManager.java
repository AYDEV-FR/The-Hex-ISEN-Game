package fr.des69u.graphical;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class FontManager {

	public Font font;
	
	public FontManager(int size) {
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/hexgon.ttf"));
		} catch (FontFormatException e1) {
			this.font = new Font("Helvetica", Font.PLAIN, size);
		} catch (IOException e1) {
			this.font = new Font("Helvetica", Font.PLAIN, size);
		}
		
		this.font = font.deriveFont(Font.PLAIN, size);
	}
	
	public Font getFont() {
		return this.font;
	}

}
