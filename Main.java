import javax.swing.*;  
import java.lang.Math;

public class Main{
    public static void main(String[] args) {
        boolean small = false;
        Setup.create();
    }
    static int roll(boolean small){
        if(small){
            return 1 + (int)(Math.floor(Math.random()*6));
        }
        return 1 + (int)(Math.floor(Math.random()*12));
    }
    static void check(){

    }
}
