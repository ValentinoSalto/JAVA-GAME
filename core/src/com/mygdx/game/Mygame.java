package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.pantallas.ScreenMenu;
import com.mygdx.game.utiles.Render;


public class Mygame extends Game {
	
	private OrthographicCamera camera;
	
	SpriteBatch batch;
	


	
	@Override
	public void create () {
		
		
		System.out.println("Bienvenido");
		Render.app = this;
		Render.batch = new SpriteBatch();
		this.setScreen(new ScreenMenu()); //Muestro pantalla de carga.
		batch = new SpriteBatch();

       

		
		
	}
	


	@Override
	public void render () {
	
		super.render();
 
	}
	
	@Override
	public void dispose () {
		
	}
}
