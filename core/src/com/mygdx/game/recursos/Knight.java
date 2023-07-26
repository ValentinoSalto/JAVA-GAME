package com.mygdx.game.recursos;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Knight {
	
	
	public Sprite spr;
	public float x, y;
	public float height,width;
	private Animation animation;
	private float time;
	//private TextureRegion [] regionsMove
	
	
	public Knight(float x, float y, float width, float height) {
		
		spr = new Sprite( new Texture(Gdx.files.internal("Personajes/Knight_1/idle.png")),71,86);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
			
		
	}

	

	public void render(final SpriteBatch batch) {
		batch.draw(spr,x,y,height,width);
		
	}
	
	
	
	
}
