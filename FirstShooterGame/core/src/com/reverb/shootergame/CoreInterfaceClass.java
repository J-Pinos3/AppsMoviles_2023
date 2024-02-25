package com.reverb.shootergame;




public class CoreInterfaceClass implements FireBaseInterface {

//    private FirebaseDatabase db;
//    public CoreInterfaceClass(){
//        db = FirebaseDatabase.getInstance();
//    }

    @Override
    public void sendPlayerPosition(float x, float y) {
//        DatabaseReference ref = db.getReference("ship_position");
//        ref.setValue(new PlayerPosition(x, y), new DatabaseReference.CompletionListener() {
//            @Override
//            public void onComplete(DatabaseError error, DatabaseReference ref) {
//                if (error == null) {
//                    // Data saved successfully
//                } else {
//                    // Handle error
//                }
//            }
//        });
        System.out.println("x: " + x  + " y: " + y);
    }


}
