package note;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class sandbox {

	public static void main(String[] args){
		
		
		sandbox2 sbox2 = new sandbox2();
		System.out.println(sbox2.sbox3.getData());
		sbox2.sbox3.setData("1");
		
		sandbox2 sbox2_1 = new sandbox2();
		System.out.println(sbox2_1.sbox3.getData());
		System.out.println(sbox2.sbox3.getData());
		
		ArrayList<sandbox2> sboxlist = new ArrayList<sandbox2>();
		
		sboxlist.add(new sandbox2());
		System.out.println(sboxlist.get(0).sbox3.getData());
		sbox2.sbox3.setData("1");
		System.out.println(sboxlist.get(0).sbox3.getData());
		sboxlist.get(0).sbox3.setData("1");
		System.out.println(sboxlist.get(0).sbox3.getData());
		
		
		/*
		
		sandbox2.sandbox3 sbox2_1 = new sandbox2.sandbox3();
		System.out.println(sbox2_1.getData());
		sbox2_1.setData("1");
		
		sandbox2.sandbox3 sbox2_2 = new sandbox2.sandbox3();
		System.out.println(sbox2_2.getData());
		System.out.println(sbox2_1.getData());
		*/
		
	}

}