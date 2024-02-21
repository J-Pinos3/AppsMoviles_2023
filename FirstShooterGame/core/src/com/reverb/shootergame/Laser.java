package com.reverb.shootergame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class Laser {


    //position  - dimensions
    float xPosition, yPosition; //bottom center of the laser
    float width, height;


    //laser physical characteristics
    float movementSpeed; //world units per second


    //graphics
    TextureRegion textureRegion;


    public Laser(float xPosition, float yPosition, float width, float height, float movementSpeed, TextureRegion textureRegion) {
        this.xPosition = xPosition - width/2;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        this.movementSpeed = movementSpeed;
        this.textureRegion = textureRegion;
    }

    public void draw(Batch batch){
        batch.draw(textureRegion, xPosition , yPosition, width, height);
    }
}
