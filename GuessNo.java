import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class GuessNo
{
    JFrame f = new JFrame("Number Guessing Game");
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton check,start,reset,quit;
    ImageIcon icon = new ImageIcon("guessIcon.jpeg");
    ImageIcon icon1 = new ImageIcon("guess.png");
    int randomNumber;
    int i=0;
    GuessNo(){
        f.setSize(1000,600);
        f.setVisible(true);
        f.getContentPane().setBackground(Color.BLACK);
        f.setLayout(null);

        //create a random number
        randomNumber = (int) (Math.random() * 100) + 1;

        f.setIconImage(icon.getImage());

        l1 = new JLabel("Guess a Number ");
        l1.setFont(new Font("Mv Boli",Font.BOLD,45));
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setBounds(30,50,550,40);
        l1.setForeground(Color.green);
        f.add(l1);

        l2 = new JLabel(icon1);
        l2.setBounds(70,150,500,350);
        f.add(l2);

        t1 = new JTextField("Guess No. From 1 to 100");
        t1.setBounds(650,150,300,40);
        t1.setBackground(new Color(102,255,102));
        t1.setForeground(Color.red);
        t1.setFont(new Font("Arial",Font.BOLD,20));
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setEnabled(false);
        f.add(t1);

        t2 = new JTextField();
        t2.setBounds(700,220,150,50);
        t2.setFont(new Font("Arial",Font.BOLD,20));
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setEnabled(false);
        f.add(t2);

        check = new JButton("Check");
        check.setBounds(720,300,110,40);
        check.setBackground(new Color(102,255,102));
        check.setFont(new Font("Arial",Font.BOLD,20));
        check.setEnabled(false);
        f.add(check);

        start = new JButton("Start ");
        start.setBounds(615,420,90,40);
        start.setBackground(new Color(153,153,255));
        start.setFont(new Font("Arial",Font.BOLD,20));
        f.add(start);

        quit = new JButton("Quit");
        quit.setBounds(735,420,90,40);
        quit.setBackground(new Color(153,153,255));
        quit.setFont(new Font("Arial",Font.BOLD,20)); 
        quit.setEnabled(false); 
        f.add(quit);

        reset = new JButton("Reset");
        reset.setBounds(855,420,90,40);
        reset.setBackground(new Color(153,153,255));
        reset.setFont(new Font("Arial",Font.BOLD,20));
        reset.setEnabled(false); 
        f.add(reset);

        l3 = new JLabel("Click start button to start the game");
        l3.setBounds(430,500,550,40);
        l3.setFont(new Font("Mv Boli",Font.BOLD,28));
        l3.setForeground(Color.red);
        f.add(l3);

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
               t1.setEnabled(true); 
               t2.setEnabled(true); 
               quit.setEnabled(true); 
               check.setEnabled(true); 
               reset.setEnabled(true); 
               l3.setText("");
            }
        });
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                f.setVisible(false);
            }
        });
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                randomNumber = (int) (Math.random() * 100) + 1;
                t1.setText("Guess No. From 1 to 100");
                t2.setText("");
                i=0;
            }
        });
        check.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                i++;
                int userGuess = Integer.parseInt(t2.getText());
                if(userGuess <=0 || userGuess >= 100){
                    t1.setText("Your Guess Is Invalid !");
                    t1.setBackground(Color.black);
                }
                else if(userGuess == randomNumber){
                    t1.setText("Congrats! You won in "+i+" guess");
                    t1.setBackground(new Color(102,255,102));
                }
                else if(userGuess < randomNumber ){
                    t1.setText("This number is Lower !");
                    t1.setBackground(new Color(102,255,102));
                    t2.setText("");
                }
                else if(userGuess > randomNumber){
                    t1.setText("This number is Higher !");
                    t1.setBackground(new Color(102,255,102));
                    t2.setText("");
                }
                else{
                    t1.setText("Your Guess Is Incorrect");
                    t1.setBackground(Color.red);
                    t2.setText("");
                }
            }
        }); 
    }
    public static void main(String[] args) {
        new GuessNo();
    }
}