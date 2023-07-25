package com.mygdx.game.pantallas;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.recursos.Imagen;
import com.mygdx.game.utiles.Config;
import com.mygdx.game.utiles.Recursos;
import com.mygdx.game.utiles.Render;

public class PantallaConfig implements Screen {
	
	Imagen fondo;
	SpriteBatch b;
	
	
	
	@Override
	public void show() {
		
		fondo = new Imagen(Recursos.FONDOCONFIG);		
		fondo.setSize(Config.ANCHO, Config.ALTO);
		b = Render.batch;
		
		
	}

	@Override
	public void render(float delta) {
		b.begin();
			fondo.dibujar();
		b.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
		
	}

	@Override
	public void pause() {
		
		
	}

	@Override
	public void resume() {
		
		
	}

	@Override
	public void hide() {
		
		
	}

	@Override
	public void dispose() {
		
		
	}
	
}
