package main.emulator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import main.emulator.sandbox.Action;

public class asd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					asd frame = new asd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	String[] list = {"Human", "Goat", "Dog", "Cat", "Duck"};
    ArrayList<JButton> button = new ArrayList<JButton>();
    JComboBox cBox = new JComboBox(list);
    JPanel container = new JPanel();
    JScrollPane scroller = new JScrollPane(container);

    public asd() {
        cBox.addActionListener(new Action());
        this.setLayout(new BorderLayout());
        this.setSize(200, 200);
        this.add(cBox, BorderLayout.SOUTH);
        this.add(scroller, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);      
    }

    public void createBtn(String s) {
        System.out.println("Button's label : " + s);
        button.add(new JButton(s));
        System.out.println("Button's index : " + (button.size() - 1));
        container.add(button.get(button.size() - 1));

        //Note the new addition
        container.validate();
    }

    public class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Action made");
            JComboBox temp = (JComboBox) e.getSource();
            createBtn(temp.getSelectedItem().toString());
        }
    }

}
