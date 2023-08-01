package com.mygdx.game.recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Knight2 {

    public enum EstadoPersonaje {
        IDLE,
        WALKING_RIGHT,
        WALKING_LEFT,
        JUMPING,
        HIT,
        COVER
    }

    private Sprite spr;
    private int x, y;
    private float height, width;
    private EstadoPersonaje estadoActual;
    private Animation<TextureRegion> walkRightAnimation;
    private Animation<TextureRegion> walkLeftAnimation;
    private float stateTime;

    public Knight2(int x, int y, float width, float height) {
        spr = new Sprite(new Texture(Gdx.files.internal("Personajes/Knight_2/idle.png")), 71, 86);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        estadoActual = EstadoPersonaje.IDLE;

        // Cargar las texturas para la animación de caminar hacia la derecha
        Texture walkRightSheet = new Texture(Gdx.files.internal("Personajes/Knight_2/walk_right.png"));
        TextureRegion[][] walkRightFrames = TextureRegion.split(walkRightSheet, 71, 86);
        TextureRegion[] walkRightAnimationFrames = walkRightFrames[0];
        walkRightAnimation = new Animation<>(0.1f, walkRightAnimationFrames);

        // Cargar las texturas para la animación de caminar hacia la izquierda
        Texture walkLeftSheet = new Texture(Gdx.files.internal("Personajes/Knight_2/walk_left.png"));
        TextureRegion[][] walkLeftFrames = TextureRegion.split(walkLeftSheet, 71, 86);
        TextureRegion[] walkLeftAnimationFrames = walkLeftFrames[0];
        walkLeftAnimation = new Animation<>(0.1f, walkLeftAnimationFrames);

        stateTime = 0f;
    }

    public void render(final SpriteBatch batch) {
        // Obtener el sprite correspondiente al estado actual
        Texture spriteTexture = null;
        switch (estadoActual) {
            case IDLE:
                spriteTexture = new Texture(Gdx.files.internal("Personajes/Knight_2/idle.png"));
                break;
            case WALKING_RIGHT:
                // Obtener el frame de la animación de caminar hacia la derecha
                spriteTexture = walkRightAnimation.getKeyFrame(stateTime, true).getTexture();
                break;
            case WALKING_LEFT:
                // Obtener el frame de la animación de caminar hacia la izquierda
                spriteTexture = walkLeftAnimation.getKeyFrame(stateTime, true).getTexture();
                break;
            // Agrega aquí los casos para los demás estados (saltar, golpear, cubrirse, etc.)
        }

        if (spriteTexture != null) {
            spr.setTexture(spriteTexture);
        }

        batch.draw(spr, x, y, width, height);
    }

    // Método para cambiar el estado del personaje
    public void cambiarEstado(EstadoPersonaje nuevoEstado) {
        estadoActual = nuevoEstado;
    }

    // Método para actualizar la animación
    public void updateAnimation(float deltaTime) {
        stateTime += deltaTime;
    }
}