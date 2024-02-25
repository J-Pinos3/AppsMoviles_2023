package com.reverb.shootergame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;


public class MyTextInputListener implements Input.TextInputListener {
    FireBaseInterface fbi;
    MyTextInputListener(FireBaseInterface _fbi){
        fbi = _fbi;
    }

    @Override
    public void input(String text) {
        if (text.equalsIgnoreCase("Sí") || text.equalsIgnoreCase("Continuar")) {
            // Reiniciar el juego
            //Gdx.app.exit();
            new SpaceShooterGame( fbi ) ;
        } else if (text.equalsIgnoreCase("No") || text.equalsIgnoreCase("Salir")) {
            Gdx.app.exit();
        }
    }

    @Override
    public void canceled() {

    }
}