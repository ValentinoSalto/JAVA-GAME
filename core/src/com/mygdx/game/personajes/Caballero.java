package com.mygdx.game.personajes;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Caballero {
	
	public Texture textura;
	public Sprite spr;
	public float alto,ancho;
	public float x, y;
	
	public Caballero(float x, float y, float ancho, float alto) {
		textura = new Texture ("Protect.png");
		spr = new Sprite(textura);
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		spr.setPosition(x,y);
		spr.setSize(ancho, alto);
		
	}

	public void dibujar(SpriteBatch batch) {
		spr.draw(batch);
		
	}
	
	
}
