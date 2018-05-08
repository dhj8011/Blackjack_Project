package com.example.scitmaster.blackjack_project;

/**
 * Created by SCITMASTER on 2018-03-04.
 */

public class Carddeck {

    private String shape;
    private String num;

public Carddeck(String shape, String num){
    this.shape=shape;
    this.num=num;
}

public void setShape(String shape){
    this.shape=shape;
}

public String getShape(){
    return shape;
}

public void setNum(String num){
    this.num=num;
}

public String getNum(){
    return num;
}

public String toString(){
    return "Card[shape :"+shape+" , num : "+num+"]";
}

}
