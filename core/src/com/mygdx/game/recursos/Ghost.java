package com.mygdx.game.recursos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Ghost {

    public enum EstadoPersonaje {
        IDLE,
        WALKING_LEFT,
        WALKING_RIGHT,
        JUMP,
        RUN,
        ATTACK,
        COVER
    }

    private Sprite spr;
    private float alto, ancho;
    private float x, y;
    private Animation<TextureRegion> idleAnimation;
    private Animation<TextureRegion> walkingLeftAnimation;
    private Animation<TextureRegion> walkingRightAnimation;
    private TextureRegion [] regionsMovement_idle;
    private TextureRegion [] regionsMovement_walking_left;
    private TextureRegion [] regionsMovement_walking_right;
    private float time;
    private TextureRegion currentFrame;
    // Define aquí las demás animaciones para los otros estados (JUMP, RUN, ATTACK, COVER)
    // ...

    private EstadoPersonaje estadoActual;

    public Ghost(float x, float y, float ancho, float alto) {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;

        // Carga las texturas para las animaciones
        Texture idleTexture = new Texture(Gdx.files.internal("Personajes/Ghost-Files/PNG/ghost-idle.png"));
        //Texture walkingLeftTexture = new Texture(Gdx.files.internal("Personajes/Knight_2/Walk_left.png"));
        //Texture walkingRightTexture = new Texture(Gdx.files.internal("Personajes/Knight_2/Walk.png"));
        //Texture attackTexture = new Texture(Gdx.files.internal("Personajes/Knight_1/"));
        // Carga las texturas para las otras animaciones (JUMP, RUN, ATTACK, COVER)
        // ...

        // Divide las texturas en regiones para las animaciones
        TextureRegion[][] idleFrames = TextureRegion.split(idleTexture, idleTexture.getWidth()/7, idleTexture.getHeight());
        regionsMovement_idle = new TextureRegion[7];
        /*TextureRegion[][] walkingLeftFrames = TextureRegion.split(walkingLeftTexture, walkingLeftTexture.getWidth()/8, walkingLeftTexture.getHeight());
        regionsMovement_walking_left = new TextureRegion[8];
        TextureRegion[][] walkingRightFrames = TextureRegion.split(walkingRightTexture, walkingRightTexture.getWidth()/8, walkingRightTexture.getHeight());
        regionsMovement_walking_right = new TextureRegion[8];*/
        //TextureRegion[][] attackFrames = TextureRegion.split(attackTexture, attackTexture.getWidth()/8,attackTexture.getHeight());
        
        // Divide las texturas para las otras animaciones (JUMP, RUN, ATTACK, COVER)
        // ...

        // Crea las animaciones con las regiones correspondientes
       /*  
        idleAnimation = new Animation<>(1 / 6f, regionsMovement_idle);
        walkingLeftAnimation = new Animation<>(1 / 6f, regionsMovement_walking_left);
        walkingRightAnimation = new Animation<>(1 / 6f, regionsMovement_walking_right);
       */  
         
         
        // Crea las animaciones con las regiones correspondientes 
        //Animacion IDLE
        for (int i = 0; i < 7; i++) {
    		regionsMovement_idle[i] = idleFrames[0][i];
        	idleAnimation = new Animation<>(1 / 6f, idleFrames[0]);
    		time = 0f;
        }
        /*
        //Animacion WALKING LEFT
        for (int i = 0; i < 8; i++) {
        	regionsMovement_walking_left[i] = walkingLeftFrames[0][i];
    		walkingLeftAnimation = new Animation<>(1 / 6f, walkingLeftFrames[0]);
    		time = 0f;
        }
        //Animacion WALKING RIGHT
        for (int i = 0; i < 8; i++) {
        	regionsMovement_walking_right[i] = walkingRightFrames[0][i];
    		 walkingRightAnimation = new Animation<>(1 / 6f, walkingRightFrames[0]);
    		time = 0f;
        }
        */
        
       
        // Crea las animaciones para las otras acciones (JUMP, RUN, ATTACK, COVER)
        // ...

        // Establece el estado inicial del personaje
        estadoActual = EstadoPersonaje.IDLE;

        // Inicializa la sprite con la animación idle
        spr = new Sprite(idleAnimation.getKeyFrame(0, true));
        spr.setPosition(x, y);
        spr.setSize(ancho, alto);
    }

    public void render(SpriteBatch batch) {
    	
    	time += Gdx.graphics.getDeltaTime();
  		currentFrame = (TextureRegion) idleAnimation.getKeyFrame(time,true);
        // Dibuja el sprite correspondiente a la animación del estado actual
    	spr.draw(batch);
      
        

    }

    public void updateAnimation(float delta) {
    	// Actualiza la animación según el estado actual del personaje
        switch (estadoActual) {
            case IDLE:
                spr.setRegion(idleAnimation.getKeyFrame(time, true));
                break;
            case WALKING_LEFT:
                spr.setRegion(walkingLeftAnimation.getKeyFrame(time, true));
                // Mueve al personaje hacia la izquierda
                x -= 3;
                break;
            case WALKING_RIGHT:
                spr.setRegion(walkingRightAnimation.getKeyFrame(time, true));
                // Mueve al personaje hacia la derecha
                x += 3;
                break;
            // Agrega las animaciones para los otros estados (JUMP, RUN, ATTACK, COVER)
            // ...
        }
        // Actualiza la posición del sprite
        spr.setPosition(x, y);
    }

    public void cambiarEstado(EstadoPersonaje nuevoEstado) {
        // Cambia el estado del personaje y actualiza la animación
        estadoActual = nuevoEstado;
        // Reinicia la animación para que comience desde el inicio al cambiar de estado
        spr.setRegion(getAnimationForCurrentState().getKeyFrame(0));
    }

    private Animation<TextureRegion> getAnimationForCurrentState() {
        // Devuelve la animación correspondiente al estado actual
        switch (estadoActual) {
            case IDLE:
                return idleAnimation;
            case WALKING_LEFT:
                return walkingLeftAnimation;
            case WALKING_RIGHT:
                return walkingRightAnimation;
            // Devuelve las animaciones para los otros estados (JUMP, RUN, ATTACK, COVER)
            // ...
            default:
                return idleAnimation;
        }
    }
}
