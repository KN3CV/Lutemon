package com.example.lutemon;

import java.util.ArrayList;

public class Storage {

    private ArrayList<Lutemon> lutemons =new ArrayList<>();
    private static Storage Storage = null;

    private Storage(){
    }

    public static Storage getInstance() {
        if(Storage == null){
            Storage = new Storage();
        }
        return Storage;
    }

    public ArrayList<Lutemon> getLutemon(){
        return lutemons;
    }

    public void addLutemon(Lutemon lutemon){
        lutemons.add(lutemon);
    }
}
