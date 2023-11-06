import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class GUI {

	private JFrame frame;
	public static int universe_width = 20;
	public static int universe_height = 30;
	public static int number_of_black_holes = 60;
	
	public static Planet home_planet;
	public static Player user_player;
	public static LinkedList<BlackHole> black_holes = new LinkedList<BlackHole>();
	public Boolean ended = false;
	public JTextPane textPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		home_planet = new Planet(universe_width, universe_height);
		user_player = new Player(universe_width, universe_height, home_planet);
		System.out.println(home_planet.x);
		System.out.println(home_planet.y);
		for (int black_hole_index = 0; black_hole_index < number_of_black_holes; black_hole_index++) {
			black_holes.add(new BlackHole(universe_width, universe_height, home_planet, user_player, black_holes)); 
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	public void userAction(int direction_x, int direction_y) {
		user_player.move(user_player.x + direction_x, user_player.y + direction_y);
		ended = home_planet.playerCollides(user_player);
		if (ended) {
			String message = "Congratulations. ";
			message +=  "You reached your planet (" + user_player.initial_x + ", " + user_player.initial_y + ")";
			message +=  "from position (" + user_player.initial_x + ", " + user_player.initial_y + ") in "+ user_player.moves + " moves";
			textPane.setText(message);
		} else {
			for (int black_hole_index = 0; black_hole_index < black_holes.size(); black_hole_index++) {
				black_holes.get(black_hole_index).playerCollides(user_player); 
			}
			textPane.setText(home_planet.indicator(user_player));
		}
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		textPane = new JTextPane();
		textPane.setBounds(10, 202, 398, 48);
		frame.getContentPane().add(textPane);
		
		JButton btnUp = new JButton("\uF0E1");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAction(0, 1);
			}
		});
		btnUp.setBounds(156, 26, 89, 23);
		frame.getContentPane().add(btnUp);
		
		JButton btnUp_Left = new JButton("\uF0E3");
		btnUp_Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAction(-1, 1);
			}
		});
		btnUp_Left.setBounds(57, 45, 89, 23);
		frame.getContentPane().add(btnUp_Left);
		
		JButton btnLeft = new JButton("\uF0DF");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAction(-1, 0);
			}
		});
		btnLeft.setBounds(57, 91, 89, 23);
		frame.getContentPane().add(btnLeft);
		
		JButton btnDown_Left = new JButton("\uF0E5");
		btnDown_Left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAction(-1, -1);
			}
		});
		btnDown_Left.setBounds(57, 142, 89, 23);
		frame.getContentPane().add(btnDown_Left);
		
		JButton btnDown = new JButton("\uF0E2");
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAction(0, -1);
			}
		});
		btnDown.setBounds(156, 168, 89, 23);
		frame.getContentPane().add(btnDown);
		
		JButton btnUp_Right = new JButton("\uF0E4");
		btnUp_Right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAction(1, 1);
			}
		});
		btnUp_Right.setBounds(255, 45, 89, 23);
		frame.getContentPane().add(btnUp_Right);
		
		JButton btnRight = new JButton("\uF0E0");
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAction(1, 0);
			}
		});
		btnRight.setBounds(255, 91, 89, 23);
		frame.getContentPane().add(btnRight);
		
		JButton btnDown_Right = new JButton("\uF0E6");
		btnDown_Right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				userAction(1, -1);
			}
		});
		btnDown_Right.setBounds(255, 142, 89, 23);
		frame.getContentPane().add(btnDown_Right);
	}
}
