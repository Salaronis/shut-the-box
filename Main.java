import javax.swing.*;  
public class Main{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton b = new JButton("1");//creating instance of JButton  
        b.setBounds(130,100,100, 40);//x axis, y axis, width, height  
          
        frame.add(b);//adding button in Jframerame  
        
                
        frame.setSize(400,500);//400 width and 500 height  
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(true);//making the framerame visible  
    }
}