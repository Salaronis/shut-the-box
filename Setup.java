import javax.swing.*;  
public class Setup {
    public static void create(){
        JFrame frame = new JFrame();
        JButton[] array = new JButton[10];
        JButton oneButton = new JButton("1");//creating instance of JButton  
        JButton twoButton = new JButton("2");
        JButton threeButton = new JButton("3");
        JButton fourButton = new JButton("3");
        JButton fiveButton = new JButton("5");
        JButton sixButton = new JButton("6");
        JButton sevenButton = new JButton("7");
        JButton eightButton = new JButton("8");
        JButton nineButton = new JButton("9");
        JButton roll = new JButton("Roll");
        array[0] = oneButton;
        array[1] = twoButton;
        array[2] = threeButton;
        array[3] = fourButton;
        array[4] = fiveButton;
        array[5] = sixButton;
        array[6] = sevenButton;
        array[7] = eightButton;
        array[8] = nineButton;
        array[9] = roll;
        for(int i = 0; i < 9; i++){
            frame.add(array[i]);
            array[i].setBounds(i*110,0,100,200);
        }
        frame.setSize(1000,600);//400 width and 500 height  
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(true);//making the framerame visible  
    }
    
}
