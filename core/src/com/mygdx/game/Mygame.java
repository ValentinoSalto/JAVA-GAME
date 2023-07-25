package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.pantallas.PantallaCarga;
import com.mygdx.game.pantallas.PantallaMenu;
import com.mygdx.game.recursos.Caballero;
import com.mygdx.game.utiles.Render;

public class Mygame extends Game {
	SpriteBatch batch;
	Caballero caballero;


	
	@Override
	public void create () {
		System.out.println("Bienvenido");
		Render.app = this;
		Render.batch = new SpriteBatch();
		this.setScreen(new PantallaMenu()); //Muestro pantalla de carga.
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
