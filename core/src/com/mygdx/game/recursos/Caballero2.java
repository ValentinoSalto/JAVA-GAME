package com.mygdx.game.recursos;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Caballero2 {
	
	public Sprite spr;
	public int x,y;
	public float height,width;
	
	public Caballero2(int x, int y, float width, float height) {
		
		spr = new Sprite(new Texture(Gdx.files.internal("Personajes/Knight_2/idle.png")),71,86);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public void render(final SpriteBatch batch) {
		batch.draw(spr,x,y,width,height);
	}
}
