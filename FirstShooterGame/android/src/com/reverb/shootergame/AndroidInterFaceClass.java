package com.reverb.shootergame;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AndroidInterFaceClass implements FireBaseInterface {

    private FirebaseDatabase db;
    public AndroidInterFaceClass(){
        db = FirebaseDatabase.getInstance();
    }

    @Override
    public void sendPlayerPosition(float x, float y) {
        DatabaseReference ref = db.getReference("ship_position");
        ref.setValue( new PlayerPosition(x, y) );
    }
}

class PlayerPosition {
    float x, y;
    public PlayerPosition(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
