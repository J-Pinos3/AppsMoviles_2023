package com.reverb.shootergame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public abstract class Ship {

    //ship caracteristics
    float movementSpeed; //world units per second
    int shield;


    //position
    Rectangle boundingBox;


    //laser information
    float laserWidth, laserHeight;
    float laserMovementSpeed;
    float timeBetweenShots;
    float timeSinceLastShot = 0;


    //graphics
    TextureRegion shipTextureRegion, shieldTextureRegion, laserTextureRegion;

    public Ship(float xCenter, float yCenter,
                float width, float height,
                float movementSpeed, int shield,
                float laserWidth, float laserHeight, float laserMovementSpeed,
                float timeBetweenShots,
                TextureRegion shipTexture, TextureRegion shieldTexture, TextureRegion laserTextureRegion) {
        this.movementSpeed = movementSpeed;
        this.shield = shield;

        this.boundingBox = new Rectangle(xCenter - width/2, yCenter - height/2, width, height);


        this.laserWidth = laserWidth;
        this.laserHeight = laserHeight;
        this.timeBetweenShots = timeBetweenShots;
        this.laserMovementSpeed = laserMovementSpeed;
        this.shipTextureRegion = shipTexture;
        this.shieldTextureRegion = shieldTexture;
        this.laserTextureRegion = laserTextureRegion;
    }

    public void update(float deltaTime){
        timeSinceLastShot += deltaTime;
    }

    public boolean canFireLaser(){
        return (timeSinceLastShot - timeBetweenShots >= 0);
    }

    public abstract Laser[] fireLasers();


    public boolean intersects(Rectangle otherRectangle){
        return boundingBox.overlaps(otherRectangle);
    }


    public void translate(float xChange, float yChange){
        boundingBox.setPosition( boundingBox.x + xChange, boundingBox.y + yChange );
    }

    public void hit(Laser laser){
        if(shield > 0){
            shield--;
        }
    }

    public void draw(Batch batch){
        batch.draw(shipTextureRegion, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        if(shield > 0){
            batch.draw(shieldTextureRegion, boundingBox.x, boundingBox.y, boundingBox.width, boundingBox.height);
        }
    }
}
