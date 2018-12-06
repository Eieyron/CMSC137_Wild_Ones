import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Game extends JPanel{
	
	//
	//	Attributes
	//

	JPanel mainPanel;
	JPanel gamePanel;
	JPanel chatPanel;

	Character ch;
	ArrayList<Character> chars;
	boolean isFinished;

	//
	//	Constructors
	//

	Game(ChatGameWindow cgw){

		this.mainPanel = new JPanel();
		this.gamePanel = new JPanel();
		this.ch = new Character("Player", new Point(50,50), this.mainPanel);

		this.isFinished = true;
		createGame();

	}

	public void createGame(){
															//background
		ImageIcon icon = new ImageIcon("./src/GAMEBG.png"); 
		Image newimg = icon.getImage().getScaledInstance(730, 550,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newimg);

		mainPanel.setLayout(null); 								//set layout to null so character can be anywhere
		mainPanel.setOpaque(false); 
		mainPanel.setPreferredSize(new Dimension(730,550));

		ImagePanel bg = new ImagePanel(newIcon.getImage());
		bg.setPreferredSize(new Dimension(730,550));
		bg.setLayout(new BorderLayout());
		bg.add(mainPanel); 										//add mainpanel to panel with bg

		this.setSize(730,700);
		this.add(bg);
	}

	//
	//	Methods
	//

	//
	//	Internal Classes
	//

	class ImagePanel extends JPanel {

	    	private Image img;
		public ImagePanel(Image img) {
			this.img = img;
			Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
			setPreferredSize(size);
			setMinimumSize(size);
			setMaximumSize(size);
			setSize(size);
			setLayout(null);
		}
		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(img, 0, 0, null);
		}
	}
}