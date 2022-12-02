import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.*;  
public class Setup{
    static JFrame frame = new JFrame("Shut the Box");
    static boolean small = false;
    static JButton[] array = new JButton[9];
    //Number Buttons
    static JButton oneButton = new JButton("1");//creating instance of JButton  
    static JButton twoButton = new JButton("2");
    static JButton threeButton = new JButton("3");
    static JButton fourButton = new JButton("4");
    static JButton fiveButton = new JButton("5");
    static JButton sixButton = new JButton("6");
    static JButton sevenButton = new JButton("7");
    static JButton eightButton = new JButton("8");
    static JButton nineButton = new JButton("9");
    //Auxillary buttons
    static JButton roll1 = new JButton("Roll 1 Die");
    static JButton roll2 = new JButton("Roll 2 Dice");
    static JButton undo = new JButton("Undo");
    static JButton confirm = new JButton("Confirm");
    //Values
    static int rollVal;
    static int selectVal = 0;
    static Stack<Integer> stack = new Stack<Integer>();
    public static void create() {
        undo.setEnabled(false);
        roll1.setEnabled(false);
        confirm.setEnabled(false);
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
                        int value = Integer.parseInt(sel.getText());
                        stack.add(value);
                        selectVal += value;
                        sel.setEnabled(false);
                        if(check()){
                            confirm.setEnabled(true);
                        }
                        if(stack.isEmpty() ==false){
                            undo.setEnabled(true);
                        }

                    }
                    System.out.println(selectVal);
                }  
            });
            array[i].setBounds((i*110)+2,0,100,200);
        }
        frame.add(undo);
        frame.add(roll1);
        frame.add(roll2);
        frame.add(confirm);
        undo.setBounds(20, 450, 300, 100);
        roll1.setBounds(345,450,125,100);
        roll2.setBounds(495,450,125,100);
        confirm.setBounds(660, 450,300,100);
        roll1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                rollVal = 1 + (int)(Math.floor(Math.random()*6));;
                System.out.println(rollVal);
                roll1.setEnabled(false);
                roll2.setEnabled(false);
            }
        });
        roll2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                rollVal = 2 + (int)(Math.floor(Math.random()*11));;
                System.out.println(rollVal);
                roll2.setEnabled(false);
                roll1.setEnabled(false);
            }
        });
        undo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int undov = stack.pop();
                array[undov-1].setEnabled(true);
                selectVal -= undov;
                if(stack.isEmpty()){
                    undo.setEnabled(false);
                }
                confirm.setEnabled(check());
            }
        });
        confirm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                stack.clear();
                undo.setEnabled(false);
                confirm.setEnabled(false);
                selectVal = 0;
                rollVal = 0;
                roll1.setEnabled(!(sevenButton.isEnabled() || eightButton.isEnabled() || nineButton.isEnabled()));
                roll2.setEnabled(true);
                System.out.println(selectVal);
                System.out.println(rollVal);
            }
        });
        frame.setSize(1000,600);//400 width and 500 height  
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(true);//making the framerame visible  
    }
    public static boolean check(){
        return rollVal == selectVal;
    }

    
}
