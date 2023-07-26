package com.mygdx.game.recursos;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Caballero3 {

	//public Texture textura;
	public Sprite spr;
	public float alto, ancho;
	public float x, y;

	public Caballero3(float x, float y, float ancho, float alto) {
		
		spr = new Sprite( new Texture(Gdx.files.internal("Personajes/Knight_3/idle.png")),71,86);;
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		

	}

	public void render(SpriteBatch batch) {
		batch.draw(spr,x,y,alto,ancho);

	}



}
