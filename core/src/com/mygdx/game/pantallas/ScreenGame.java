package com.mygdx.game.pantallas;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.recursos.Knight;
import com.mygdx.game.recursos.Knight3;
import com.mygdx.game.utiles.Render;

public class ScreenGame implements Screen{

	Image personaje;
	SpriteBatch b;
	private Knight3 knight;
	ShapeRenderer sr; // Agrega un objeto ShapeRenderer
	
	
	@Override
	public void show() { 
		/*personaje = new Imagen(Recursos.CABALLERO);		
		personaje.setSize(Config.PERSONAJEANCHO, Config.PERSONAJEALTO);
		personaje.setPosition(Config.X, Config.Y);
		*/
		b = Render.batch;
		sr = new ShapeRenderer(); // Inicializa el ShapeRenderer
		
        knight = new Knight3(100,100, 200, 200);
        
        
		
		
		
		
	}
	private void update(float delta) {
       
		
    }

	@Override
	public void render(float delta) {
		// Limpio la pantalla (solamente para ver bien el caballero despues va a tener un fondo)
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		

        // Maneja las entradas del teclado para cambiar el estado del personaje
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) || Gdx.input.isKeyPressed(Input.Keys.A)) {
            knight.cambiarEstado(Knight3.EstadoPersonaje.WALKING_LEFT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) || Gdx.input.isKeyPressed(Input.Keys.D)) {
            knight.cambiarEstado(Knight3.EstadoPersonaje.WALKING_RIGHT);
        } else if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
        	knight.cambiarEstado(Knight3.EstadoPersonaje.JUMP);
        } else if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
        	knight.cambiarEstado(Knight3.EstadoPersonaje.ATTACK);
        } else if (Gdx.input.isButtonPressed(Input.Buttons.RIGHT)) {
        	knight.cambiarEstado(Knight3.EstadoPersonaje.COVER);
        } else {
        	knight.cambiarEstado(Knight3.EstadoPersonaje.IDLE);
        }

        // Actualiza la animación del personaje según el estado actual
        knight.updateAnimation(delta);

		
	
					
        b.begin();
		
			knight.render(b);
	
			
		b.end();
		
		// Inicia el dibujado de líneas
		sr.begin(ShapeType.Line);
			sr.setColor(255, 0, 0, 1); // Establece el color de la línea (blanco en este caso)

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
