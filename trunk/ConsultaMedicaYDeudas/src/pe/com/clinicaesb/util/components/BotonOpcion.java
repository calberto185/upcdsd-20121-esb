package pe.com.clinicaesb.util.components;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.Font;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.Keypad;
import net.rim.device.api.ui.Ui;
import pe.com.clinicaesb.util.Constantes;
import pe.com.clinicaesb.util.Util;

/**
 * @author Synopsis
 * 
 */
public class BotonOpcion extends Field {
	
	private int tamanioLetra = Util.tamanioTexto();

	private int altura = -1;
	private int ancho = -1;

	private int textColorUnfocused = Constantes.COLOR_LETRA_BOTON_SINFOCO;
	private int textColorFocused = Constantes.COLOR_LETRA_BOTON;
	private int backgroundColorUnfocused = Constantes.COLOR_BOTON_SINFOCO;
	private int backgroundColorFocused = Constantes.COLOR_BOTON_FOCO_GRIS;
	private String label;
	private int verticalPadding = 3;

	public int getTextColorUnfocused() {
		return textColorUnfocused;
	}

	public void setTextColorUnfocused(int textColorUnfocused) {
		this.textColorUnfocused = textColorUnfocused;
	}

	public int getTextColorFocused() {
		return textColorFocused;
	}

	public void setTextColorFocused(int textColorFocused) {
		this.textColorFocused = textColorFocused;
	}

	public int getBackgroundColorUnfocused() {
		return backgroundColorUnfocused;
	}

	public void setBackgroundColorUnfocused(int backgroundColorUnfocused) {
		this.backgroundColorUnfocused = backgroundColorUnfocused;
	}

	public int getBackgroundColorFocused() {
		return backgroundColorFocused;
	}

	public void setBackgroundColorFocused(int backgroundColorFocused) {
		this.backgroundColorFocused = backgroundColorFocused;
	}

	public int getAncho() {
		return ancho;
	}

	public BotonOpcion(String label, long consumeClick) {
		super(consumeClick);
		this.label = label;
	}

	public BotonOpcion(String label, int textColorUnfocused, int textColorFocused, int backgroundColorUnfocused, int backgroundColorFocused, int width, long style) {
		super(style);
		this.label = label;
		this.textColorUnfocused = textColorUnfocused;
		this.textColorFocused = textColorFocused;
		this.backgroundColorUnfocused = backgroundColorUnfocused;
		this.backgroundColorFocused = backgroundColorFocused;
		this.ancho = width;
	}
	
	public BotonOpcion(String label, long consumeClick, int backgroundColorFocused) {
		super(consumeClick);
		this.label = label;
		this.backgroundColorFocused = backgroundColorFocused;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	
	

	public int getVerticalPadding() {
		return verticalPadding;
	}

	public void setVerticalPadding(int verticalPadding) {
		this.verticalPadding = verticalPadding;
	}

	public int getPreferredWidth() {
		if (ancho == -1) {
			return Util.getAnchoPantalla() - (2 * Constantes.MARGIN_PANTALLA);
		}
		return ancho;
	}

	public int getPreferredHeight() {
		if (altura == -1) {
			return super.getPreferredHeight();
		}
		return altura;
	}

	protected void layout(int width, int height) {
		setExtent(Math.min(getPreferredWidth(), width), Math.min(getPreferredHeight(), height));
	}

	protected void paint(Graphics graphics) {
		// Draw background
		graphics.setColor(isFocus() ? backgroundColorFocused : backgroundColorUnfocused);
		graphics.fillRoundRect(0, 0, getPreferredWidth(), getPreferredHeight(), 10, 10);

		// Draw text
		graphics.setColor(isFocus() ? textColorFocused : textColorUnfocused);
		graphics.drawRoundRect(0, 0, getPreferredWidth(), getPreferredHeight(), 10, 10);

		Font f = graphics.getFont();
		Font newf = f.derive(Font.PLAIN, tamanioLetra+1, Ui.UNITS_px);

		graphics.setFont(newf);
		int fontWidth = newf.getAdvance(label);
		int fontHeight = newf.getHeight();
		graphics.drawText(label, (getPreferredWidth() / 2) - (fontWidth / 2), (getPreferredHeight() / 2) - (fontHeight / 2));

	}

	protected void drawFocus(Graphics graphics, boolean on) {
		// Don't draw the default focus
	}

	protected void onFocus(int direction) {
		super.onFocus(direction);
		invalidate();
	}

	protected void onUnfocus() {
		super.onUnfocus();
		invalidate();
	}

	public boolean isFocusable() {
		return true;
	}

	protected boolean navigationClick(int status, int time) {
		fieldChangeNotify(0);
		return true;
	}

	protected boolean keyChar(char character, int status, int time) {
		if (character == Keypad.KEY_ENTER) {
			fieldChangeNotify(0);
			return true;
		}
		return super.keyChar(character, status, time);
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

}
