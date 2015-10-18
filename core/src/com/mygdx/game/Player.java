package com.mygdx.game;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.math.Vector2;
import com.uwsoft.editor.renderer.components.TransformComponent;
import com.uwsoft.editor.renderer.scripts.IScript;
import com.uwsoft.editor.renderer.utils.ComponentRetriever;


/**
 * Created by Jaden on 17/10/2015.
 */
public class Player implements IScript {

    private Entity player;
    private TransformComponent transformComponent;


    //move smoother
    private float horizontalSpeed = 100f;

    private float gravity = -360f;
    private Vector2 speed;

    private final float jumpSpeed = 200f;
    @Override
    public void init(Entity entity) {
        player = entity;
        transformComponent = ComponentRetriever.get(entity, TransformComponent.class);
        speed = new Vector2(100, 0);

    }



    @Override
    public void act(float delta) {


        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            transformComponent.x -= horizontalSpeed*delta;
            transformComponent.scaleX = -1f;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            transformComponent.x  += horizontalSpeed*delta;
            transformComponent.scaleX = 1f;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            speed.y = jumpSpeed;

        }


        speed.y += gravity*delta;
        transformComponent.y += speed.y * delta;

        //prevent the player from going through the ground.
        if(transformComponent.y < 21f) {
            speed.y = 0;
            transformComponent.y = 21f;
        }
    }

    public float getX() {
        return transformComponent.x;
    }
    public float getY() {
        return transformComponent.y;
    }
    @Override
    public void dispose() {

    }
}
