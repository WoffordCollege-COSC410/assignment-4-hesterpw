package edu.wofford;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GuiMain extends JFrame implements ActionListener {

    private JPanel pnlButtons;
    private JLabel lblResult;
    public JButton Location00;
    public JButton Location01;
    public JButton Location02;
    public JButton Location10;
    public JButton Location11;
    public JButton Location12;
    public JButton Location20;
    public JButton Location21;
    public JButton Location22;

    public void actionPerformed(ActionEvent event) {

    }

    public GuiMain() {
        setTitle("Tic Tac Toe");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLayout(new BorderLayout());

        // lblResult = new JLabel("Result");
        // add(lblResult);


        // // pnlButtons.setLayout(new GridLayout(3,3));
        // pblButtons = new JPanel()
        //
        Location00 = new JButton("00");
        add(Location00);
        Location01 = new JButton("01");
        add(Location01);
        Location02 = new JButton("02");
        add(Location02);
        Location10 = new JButton("10");
        add(Location10);
        Location11 = new JButton("11");
        add(Location11);
        Location12 = new JButton("12");
        add(Location12);
        Location20 = new JButton("20");
        add(Location20);
        Location21 = new JButton("21");
        add(Location21);
        Location22 = new JButton("22");
        add(Location22);


    }


	public static void main(String[] args) {
	    GuiMain window = new GuiMain();
        window.setVisible(true);
	}
}
