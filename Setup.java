import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.*;  
public class Setup{
    static JFrame frame = new JFrame("Shut the Box");
    static boolean small = false;
    static JButton[] array = new JButton[9];
    //Number Buttons
    static JButton oneButton = new JButton("1");//creating instance of JButton  
    static JButton twoButton = new JButton("2");
    static JButton threeButton = new JButton("3");
    static JButton fourButton = new JButton("3");
    static JButton fiveButton = new JButton("5");
    static JButton sixButton = new JButton("6");
    static JButton sevenButton = new JButton("7");
    static JButton eightButton = new JButton("8");
    static JButton nineButton = new JButton("9");
    //Auxillary buttons
    static JButton roll = new JButton("Roll");
    static JButton clear = new JButton("Clear");
    static JButton confirm = new JButton("Confirm");
    
    static int rollVal;
    static int selectVal = 0;
    static HashSet<Integer> set = new HashSet<>();
    public static void create() {
        array[0] = oneButton;
        array[1] = twoButton;
        array[2] = threeButton;
        array[3] = fourButton;
        array[4] = fiveButton;
        array[5] = sixButton;
        array[6] = sevenButton;
        array[7] = eightButton;
        array[8] = nineButton;
        for(int i = 0; i < 9; i++){
            JButton sel = array[i];
            frame.add(sel);
            sel.addActionListener( new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(sel.isEnabled()){
                        selectVal += Integer.parseInt(sel.getText());
                    }else{
                        selectVal -= Integer.parseInt(sel.getText());
                    }
                    sel.setEnabled(!sel.isEnabled());
                }  
            });
            array[i].setBounds((i*110)+2,0,100,200);
        }
        frame.add(roll);
        roll.setBounds(350,450,300,100);
        frame.setSize(1000,600);//400 width and 500 height  
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(true);//making the framerame visible  
    }
    public static boolean check(){
        return rollVal == selectVal;
    }
    static int roll(boolean small){
        int val;
        if(small){
            val = 1 + (int)(Math.floor(Math.random()*6));
        }else{
            val = 1 + (int)(Math.floor(Math.random()*12));
        }
        return val;
    }

    
}
