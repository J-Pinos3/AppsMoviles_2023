package com.reverb.shootergame;


import com.badlogic.gdx.Game;

import java.util.Random;

import pl.mk5.gdx.fireapp.GdxFIRApp;

public class SpaceShooterGame extends Game {

	GameScreen gameScreen;
	public static Random random = new Random();
	FireBaseInterface fbic;
	public SpaceShooterGame(FireBaseInterface FBIC){
		fbic = FBIC;
	}

	@Override
	public void create() {
		GdxFIRApp.inst().configure();

		gameScreen = new GameScreen( fbic );
		setScreen(gameScreen);


	}

	@Override
	public void dispose() {
		gameScreen.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		gameScreen.resize(width, height);
	}
}
