package com.mygdx.game.desktop;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Mygame;
import com.mygdx.game.utiles.Config;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Java Souls";
		//config.fullscreen = true;
		//config.foregroundFPS = 60;
		config.resizable = false;
		config.width = Config.ANCHO;
		config.height = Config.ALTO;
		new LwjglApplication(new Mygame(), config);
	}
}
