package com.reverb.shootergame;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.awt.HeadlessException;

public class EnemyShip extends Ship{



    public EnemyShip(float xCenter, float yCenter,
                      float width, float height,
                      float movementSpeed, int shield,
                      float laserWidth, float laserHeight,
                      float laserMovementSpeed, float timeBetweenShots,
                      TextureRegion shipTexture, TextureRegion shieldTexture, TextureRegion laserTextureRegion) {
        super(xCenter, yCenter, width, height, movementSpeed, shield, laserWidth, laserHeight, laserMovementSpeed, timeBetweenShots, shipTexture, shieldTexture, laserTextureRegion);
    }


    @Override
    public Laser[] fireLasers() {

        Laser[] laser = new Laser[2];//2 cuz lasers go out from 2 sides of the ship

        laser[0] = new Laser(xPosition + width * 0.18f, yPosition - laserHeight,
                laserWidth, laserHeight, laserMovementSpeed, laserTextureRegion);


        laser[1] = new Laser(xPosition + width * 0.82f, yPosition - laserHeight,
                laserWidth, laserHeight, laserMovementSpeed, laserTextureRegion);

        timeSinceLastShot = 0;
        return laser;
    }

    @Override
    public void draw(Batch batch){
        batch.draw(shipTextureRegion, xPosition, yPosition, width, height);
        if(shield > 0){
            batch.draw(shieldTextureRegion, xPosition, yPosition- height*0.2f, width, height);
        }
    }

}
