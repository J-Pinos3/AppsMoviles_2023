package com.reverb.shootergame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.ListIterator;

class GameScreen implements Screen {

//todo KEEP ALONG WITH VIDEO 4 11:20
    //screen
    private Camera camera;
    private Viewport viewport;

    //graphic
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;

    private TextureRegion[] backgrounds;
    private float backgroundHeight;//height of background in world units

    private TextureRegion playerShipTextureRegion, playerShieldTextureRegion,
        enemyShipTextureRegion, enemyShieldTextureRegion,
        playerLaserTextureRegion, enemyLaserTextureRegion ;

    //timing
//    private int backgroundOffset;
    private float[] backgroundOffsets = {0,0,0,0};
    private float backgroundMaxScrollingSpeed;

    //world parameters
    private final int WORLD_WIDTH = 72;
    private final int WORLD_HEIGHT = 128;

    //game objects
    private Ship  playerShip;
    private Ship  enemyShip;
    private LinkedList<Laser> playerLaserList;
    private LinkedList<Laser> enemyLaserList;


    GameScreen(){
        camera = new OrthographicCamera();
        viewport = new StretchViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);

        //set up texture atlas
        textureAtlas = new TextureAtlas("images.atlas");

        backgrounds = new TextureRegion[4];
        backgrounds[0] = textureAtlas.findRegion("Starscape00");
        backgrounds[1] = textureAtlas.findRegion("Starscape01");
        backgrounds[2] = textureAtlas.findRegion("Starscape02");;
        backgrounds[3] = textureAtlas.findRegion("Starscape03");

        backgroundHeight = WORLD_HEIGHT*2;
        backgroundMaxScrollingSpeed = (float)(WORLD_HEIGHT) / 4;


        //init texture regions
        playerShipTextureRegion     = textureAtlas.findRegion("playerShip2_blue");
        enemyShipTextureRegion      = textureAtlas.findRegion("enemyRed3");
        playerShieldTextureRegion   = textureAtlas.findRegion("shield2");
        enemyShieldTextureRegion    = textureAtlas.findRegion("shield1");
        enemyShieldTextureRegion.flip(false, true);

        playerLaserTextureRegion    = textureAtlas.findRegion("laserBlue03");
        enemyLaserTextureRegion     = textureAtlas.findRegion("laserRed03");

        playerShip = new PlayerShip(WORLD_WIDTH/2, WORLD_HEIGHT/4,
                10, 10,
                2, 3,
                0.4f, 4f, 45f, 0.5f,
                playerShipTextureRegion, playerShieldTextureRegion, playerLaserTextureRegion);

        enemyShip = new EnemyShip(WORLD_WIDTH/2, WORLD_HEIGHT*3/4,
                10, 10,
                2, 3,
                0.3f, 5f, 50f, 0.8f,
                enemyShipTextureRegion, enemyShieldTextureRegion, enemyLaserTextureRegion);


        playerLaserList = new LinkedList<>();
        enemyLaserList = new LinkedList<>();

        batch = new SpriteBatch();


    }

    @Override
    public void show() {

    }

    @Override
    public void render(float deltaTime) {
        batch.begin();

        playerShip.update(deltaTime);
        enemyShip.update(deltaTime);

        //scrolling background
        renderBackground(deltaTime);

        //enemy ships
        enemyShip.draw(batch);

        //player ship
        playerShip.draw(batch);

        //lasers
        //create new lasers
                //player lasers
        if(playerShip.canFireLaser() ){
            Laser[] lasers = playerShip.fireLasers();
            for(Laser laser : lasers){
                playerLaserList.add(laser);
            }
        }

                //enemy lasers
        if(enemyShip.canFireLaser()){
            Laser[] lasers = enemyShip.fireLasers();
            for(Laser laser : lasers){
                enemyLaserList.add(laser);
            }
        }

        //draw lasers
        //remove old lasers
        ListIterator<Laser> iterator = playerLaserList.listIterator();
        while(iterator.hasNext()){
            Laser laser = iterator.next();
            laser.draw(batch);
            laser.yPosition += laser.movementSpeed* deltaTime;
            if(laser.yPosition > WORLD_HEIGHT){
                iterator.remove();//remove last item
            }
        }


        iterator = enemyLaserList.listIterator();
        while(iterator.hasNext()){
            Laser laser = iterator.next();
            laser.draw(batch);
            laser.yPosition -= laser.movementSpeed* deltaTime;
            if(laser.yPosition + laser.height < 0){
                iterator.remove();//remove last item
            }
        }

        //explosions



        batch.end();
    }

    private void renderBackground(float deltaTime) {

        backgroundOffsets[0] += deltaTime * backgroundMaxScrollingSpeed/8;
        backgroundOffsets[1] += deltaTime * backgroundMaxScrollingSpeed/4;
        backgroundOffsets[2] += deltaTime * backgroundMaxScrollingSpeed/2;
        backgroundOffsets[3] += deltaTime * backgroundMaxScrollingSpeed;

        for(int layer = 0; layer < backgroundOffsets.length; layer++){
            if(backgroundOffsets[layer] > WORLD_HEIGHT){
                backgroundOffsets[layer] = 0;
            }
            batch.draw(backgrounds[layer], 0, -backgroundOffsets[layer],
                    WORLD_WIDTH, backgroundHeight);

        }
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
        batch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
