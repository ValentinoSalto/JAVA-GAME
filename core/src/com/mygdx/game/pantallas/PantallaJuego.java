package com.mygdx.game.pantallas;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.recursos.Imagen;
import com.mygdx.game.utiles.Config;
import com.mygdx.game.utiles.Recursos;
import com.mygdx.game.utiles.Render;

public class PantallaJuego implements Screen{

	Imagen personaje;
	SpriteBatch b;
	
	ShapeRenderer sr; // Agrega un objeto ShapeRenderer
	
	@Override
	public void show() { 
		personaje = new Imagen(Recursos.CABALLERO);		
		personaje.setSize(Config.PERSONAJEANCHO, Config.PERSONAJEALTO);
		personaje.setPosition(Config.X, Config.Y);
		b = Render.batch;
		sr = new ShapeRenderer(); // Inicializa el ShapeRenderer
		
		
	}

	@Override
	public void render(float delta) {
		b.begin();
			// Limpio la pantalla
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			personaje.dibujar();
		b.end();

		// Inicia el dibujado de líneas
		sr.begin(ShapeType.Line);
			sr.setColor(1, 1, 1, 1); // Establece el color de la línea (blanco en este caso)

			// Dibuja la línea del piso desde (x1, y1) a (x2, y2)
			sr.line(0, 100, Gdx.graphics.getWidth(), 100);

		// Finaliza el dibujado de líneas
		sr.end();
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
