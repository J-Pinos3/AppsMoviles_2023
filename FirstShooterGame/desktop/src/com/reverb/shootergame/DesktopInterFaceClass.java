package com.reverb.shootergame;


public class DesktopInterFaceClass implements FireBaseInterface{

//    private FirebaseDatabase db;
//    public DesktopInterFaceClass(){
//        db = FirebaseDatabase.getInstance();
//    }

    @Override
    public void sendPlayerPosition(float x, float y) {
//        DatabaseReference ref = db.getReference("ship_position");
//        ref.setValue( new PlayerPosition(x, y) );
    }
}

class PlayerPosition {
    float x, y;
    public PlayerPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
}

