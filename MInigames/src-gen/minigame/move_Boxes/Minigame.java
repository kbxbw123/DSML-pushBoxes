package minigame.move_Boxes;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.Color;


public class Minigame extends javax.swing.JPanel implements Runnable 
{

	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
	{
		java.awt.EventQueue.invokeLater(new GameWindow());
	}

	private static class GameWindow extends javax.swing.JFrame implements Runnable 
	{
		private static final long serialVersionUID = 1L;

		public GameWindow() 
		{
			add(new Minigame(this));
			setTitle("move_Boxes");
			setResizable(false);
			pack(); 
			setLocationRelativeTo(null); 

			if (x != null)
				setLocation(x, getY());
			if (y != null)
				setLocation(getX(), y);

			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

		@Override
		public void run() 
		{
			setVisible(true); 
		}
	}


	public static int height = 160;
	public static int width = 160;
	public static Integer x = null;
	public static Integer y = null;


	public Minigame(GameWindow window) 
	{
		setPreferredSize(new java.awt.Dimension(width, height));
		setDoubleBuffered(true); 
		window.addKeyListener(onEvent);
	}

	@Override
	public void addNotify() 
	{
		super.addNotify();
		new Thread(this).start();
	}
	@Override
	public void run() 
	{
		while (true) {repaint();}
		
	}

	@Override
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		for (Character o : characters)
			if (b(o.visible))
				o.draw(g);
		java.awt.Toolkit.getDefaultToolkit().sync();
	}

	private static abstract	class Character 
	{
		public int visible = 1;
		public int x;
		public int y;
		public int edge;

		public abstract void draw(Graphics g);
	}

	private static class Player extends Character 
	{
		@Override
		public void draw(Graphics g) {
			g.fillOval(x, y, edge, edge);
		}
	}

	private static class Obstacle extends Character 
	{
		@Override
		public void draw(Graphics g) {
			g.fillRect(x, y, edge, edge);
		}
	}

	private static class GameProps extends Character 
	{
		@Override
		public void draw(Graphics g) {
			g.fillPolygon(new int[] { x, x + edge, x + edge / 2 }, new int[] { y, y, y + edge }, 3);
		}
	}

	private static class Destination extends Character 
	{
		@Override
		public void draw(Graphics g) {
			g.setColor(new Color(255, 0, 0)); 
			g.fillPolygon(new int[] { x, x + edge, x + edge / 2 }, new int[] { y, y, y + edge }, 3);
			g.setColor(new Color(0, 0, 0)); 
		}
	}


	private boolean b(int i) {
		return i != 0;
	}

	private int i(boolean b) {
		return b ? 1 : 0;
	}

	private int eq(int left, int right) {
		return i(left == right);
	}

	private int lt(int left, int right) {
		return i(left < right);
	}

	private int not(int value) {
		return i(!b(value));
	}


	{
		width = 160;
		height = 230;
	}

	private int _i;
	private int _j;
	private int _isboxnwall;
	private int _isboxnbox;
	private int _iswall;
	private int _isbox;
	private int _num_destination = 3;
	private int _counter = 0;
	private Destination[] _destinations = new Destination[] { new Destination(), new Destination(), new Destination() };
	private GameProps[] _boxes = new GameProps[] { new GameProps(), new GameProps(), new GameProps() };
	private Player _player = new Player() {
		{
			x = 40;
			y = 20;
			edge = 20;
		}
	};
	private Obstacle[] _obstacles = new Obstacle[] { new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle() };
	private Obstacle[] _winsign = new Obstacle[] { new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle(), new Obstacle() };

	private Character[] characters = new Character[] 
	{ 
		_destinations[0], _destinations[1], _destinations[2], _boxes[0], _boxes[1], _boxes[2], _player, _obstacles[0], _obstacles[1], _obstacles[2], _obstacles[3], _obstacles[4], _obstacles[5], _obstacles[6], _obstacles[7], _obstacles[8], _obstacles[9], _obstacles[10], _obstacles[11], _obstacles[12], _obstacles[13], _obstacles[14], _obstacles[15], _obstacles[16], _obstacles[17], _obstacles[18], _obstacles[19], _obstacles[20], _obstacles[21], _obstacles[22], _obstacles[23], _obstacles[24], _obstacles[25], _obstacles[26], _obstacles[27], _obstacles[28], _obstacles[29], _obstacles[30], _obstacles[31], _obstacles[32], _obstacles[33], _winsign[0], _winsign[1], _winsign[2], _winsign[3], _winsign[4], _winsign[5], _winsign[6], _winsign[7], _winsign[8], _winsign[9], _winsign[10], _winsign[11], _winsign[12], _winsign[13], _winsign[14], _winsign[15], _winsign[16], _winsign[17], _winsign[18], _winsign[19], _winsign[20], _winsign[21], _winsign[22], _winsign[23], _winsign[24], _winsign[25], _winsign[26], _winsign[27], _winsign[28]
	};
	
	{
			for (_i = 0; b(lt(_i,3)); _i = (_i + 1)) 
			{
					_boxes[_i].edge = 20;
					_destinations[_i].edge = 20;
					}
			for (_i = 0; b(lt(_i,34)); _i = (_i + 1)) 
			{
					_obstacles[_i].edge = 20;
					}
			_destinations[0].x = 20;
			_destinations[0].y = 80;
			_destinations[1].x = 40;
			_destinations[1].y = 40;
			_destinations[2].x = 20;
			_destinations[2].y = 120;
			_boxes[0].x = 60;
			_boxes[0].y = 40;
			_boxes[1].x = 40;
			_boxes[1].y = 100;
			_boxes[2].x = 100;
			_boxes[2].y = 120;
			for (_i = 0; b(lt(_i,5)); _i = (_i + 1)) 
			{
					_obstacles[_i].x = (20 + (_i * 20) );
					_obstacles[_i].y = 0;
					}
			_obstacles[5].x = 20;
			_obstacles[5].y = 20;
			for (_i = 0; b(lt(_i,3)); _i = (_i + 1)) 
			{
					_obstacles[(_i + 6)].x = (80 + (_i * 20) );
					_obstacles[(_i + 6)].y = 20;
					}
			_obstacles[9].x = 20;
			_obstacles[9].y = 40;
			_obstacles[10].x = 120;
			_obstacles[10].y = 40;
			for (_i = 0; b(lt(_i,3)); _i = (_i + 1)) 
			{
					_obstacles[(_i + 11)].x = (_i * 20) ;
					_obstacles[(_i + 11)].y = 60;
					}
			_obstacles[14].x = 80;
			_obstacles[14].y = 60;
			for (_i = 0; b(lt(_i,2)); _i = (_i + 1)) 
			{
					_obstacles[(_i + 15)].x = (120 + (_i * 20) );
					_obstacles[(_i + 15)].y = 60;
					}
			_obstacles[17].x = 0;
			_obstacles[17].y = 80;
			_obstacles[18].x = 40;
			_obstacles[18].y = 80;
			_obstacles[19].x = 80;
			_obstacles[19].y = 80;
			_obstacles[20].x = 140;
			_obstacles[20].y = 80;
			_obstacles[21].x = 0;
			_obstacles[21].y = 100;
			_obstacles[22].x = 100;
			_obstacles[22].y = 100;
			_obstacles[23].x = 140;
			_obstacles[23].y = 100;
			_obstacles[24].x = 0;
			_obstacles[24].y = 120;
			_obstacles[25].x = 140;
			_obstacles[25].y = 120;
			for (_i = 0; b(lt(_i,8)); _i = (_i + 1)) 
			{
					_obstacles[(_i + 26)].x = (_i * 20) ;
					_obstacles[(_i + 26)].y = 140;
					}
			for (_i = 0; b(lt(_i,4)); _i = (_i + 1)) 
			{
					_winsign[_i].x = 5;
					_winsign[_i].y = (180 + (_i * 10) );
					}
			_winsign[4].x = 15;
			_winsign[4].y = 210;
			for (_i = 0; b(lt(_i,4)); _i = (_i + 1)) 
			{
					_winsign[(_i + 5)].x = 25;
					_winsign[(_i + 5)].y = (180 + (_i * 10) );
					}
			_winsign[9].x = 35;
			_winsign[9].y = 210;
			for (_i = 0; b(lt(_i,4)); _i = (_i + 1)) 
			{
					_winsign[(_i + 10)].x = 45;
					_winsign[(_i + 10)].y = (180 + (_i * 10) );
					}
			for (_i = 0; b(lt(_i,4)); _i = (_i + 1)) 
			{
					_winsign[(_i + 14)].x = 65;
					_winsign[(_i + 14)].y = (180 + (_i * 10) );
					}
			for (_i = 0; b(lt(_i,4)); _i = (_i + 1)) 
			{
					_winsign[(_i + 18)].x = 85;
					_winsign[(_i + 18)].y = (180 + (_i * 10) );
					}
			_winsign[22].x = 95;
			_winsign[22].y = 180;
			_winsign[23].x = 105;
			_winsign[23].y = 190;
			_winsign[24].x = 115;
			_winsign[24].y = 200;
			for (_i = 0; b(lt(_i,4)); _i = (_i + 1)) 
			{
					_winsign[(_i + 25)].x = 125;
					_winsign[(_i + 25)].y = (180 + (_i * 10) );
					}
			for (_i = 0; b(lt(_i,29)); _i = (_i + 1)) 
			{
					_winsign[_i].visible = 0;
					_winsign[_i].edge = 10;
					}
			}

	java.awt.event.KeyListener onEvent = new java.awt.event.KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT: {
					_isboxnwall = 0;
					_isboxnbox = 0;
					_isbox = 0;
					_iswall = 0;
					for (_i = 0; b(lt(_i,3)); _i = (_i + 1)) 
					{
							if (b(eq((_player.x - 20), _boxes[_i].x)))
							{
									if (b(eq(_player.y, _boxes[_i].y)))
									{
											_isbox = 1;
											for (_j = 0; b(lt(_j,34)); _j = (_j + 1)) 
											{
													if (b(eq((_boxes[_i].x - 20), _obstacles[_j].x)))
													{
															if (b(eq(_boxes[_i].y, _obstacles[_j].y)))
															{
																	_isboxnwall = 1;
																	_j = 34;
																	}
															}
													}
											if (b(eq(_isboxnwall, 0)))
											{
													for (_j = 0; b(lt(_j,3)); _j = (_j + 1)) 
													{
															if (b(not(eq(_i, _j))))
															{
																	if (b(eq((_boxes[_i].x - 20), _boxes[_j].x)))
																	{
																			if (b(eq(_boxes[_i].y, _boxes[_j].y)))
																			{
																					_isboxnbox = 1;
																					_j = 3;
																					}
																			}
																	}
															}
													if (b(eq(_isboxnbox, 0)))
													{
															for (_j = 0; b(lt(_j,3)); _j = (_j + 1)) 
															{
																	if (b(eq((_boxes[_i].x - 20), _destinations[_j].x)))
																	{
																			if (b(eq(_boxes[_i].y, _destinations[_j].y)))
																			{
																					_counter = (_counter + 1);
																					}
																			}
																	}
															_boxes[_i].x = (_boxes[_i].x - 20);
															_player.x = (_player.x - 20);
															}
													}
											}
									}
							}
					if (b(eq(_isbox, 0)))
					{
							for (_j = 0; b(lt(_j,34)); _j = (_j + 1)) 
							{
									if (b(eq((_player.x - 20), _obstacles[_j].x)))
									{
											if (b(eq(_player.y, _obstacles[_j].y)))
											{
													_iswall = 1;
													_j = 34;
													}
											}
									}
							if (b(eq(_iswall, 0)))
							{
									_player.x = (_player.x - 20);
									}
							}
					if (b(eq(_counter, _num_destination)))
					{
							for (_i = 0; b(lt(_i,29)); _i = (_i + 1)) 
							{
									_winsign[_i].visible = 1;
									}
							}
					}
				break;
			case KeyEvent.VK_RIGHT: {
					_isboxnwall = 0;
					_isboxnbox = 0;
					_iswall = 0;
					_isbox = 0;
					for (_i = 0; b(lt(_i,3)); _i = (_i + 1)) 
					{
							if (b(eq((_player.x + 20), _boxes[_i].x)))
							{
									if (b(eq(_player.y, _boxes[_i].y)))
									{
											_isbox = 1;
											for (_j = 0; b(lt(_j,34)); _j = (_j + 1)) 
											{
													if (b(eq((_boxes[_i].x + 20), _obstacles[_j].x)))
													{
															if (b(eq(_boxes[_i].y, _obstacles[_j].y)))
															{
																	_isboxnwall = 1;
																	_j = 34;
																	}
															}
													}
											if (b(eq(_isboxnwall, 0)))
											{
													for (_j = 0; b(lt(_j,3)); _j = (_j + 1)) 
													{
															if (b(not(eq(_i, _j))))
															{
																	if (b(eq((_boxes[_i].x + 20), _boxes[_j].x)))
																	{
																			if (b(eq(_boxes[_i].y, _boxes[_j].y)))
																			{
																					_isboxnbox = 1;
																					_j = 3;
																					}
																			}
																	}
															}
													if (b(eq(_isboxnbox, 0)))
													{
															for (_j = 0; b(lt(_j,3)); _j = (_j + 1)) 
															{
																	if (b(eq((_boxes[_i].x + 20), _destinations[_j].x)))
																	{
																			if (b(eq(_boxes[_i].y, _destinations[_j].y)))
																			{
																					_counter = (_counter + 1);
																					}
																			}
																	}
															_boxes[_i].x = (_boxes[_i].x + 20);
															_player.x = (_player.x + 20);
															}
													}
											}
									}
							}
					if (b(eq(_isbox, 0)))
					{
							for (_j = 0; b(lt(_j,34)); _j = (_j + 1)) 
							{
									if (b(eq((_player.x + 20), _obstacles[_j].x)))
									{
											if (b(eq(_player.y, _obstacles[_j].y)))
											{
													_iswall = 1;
													_j = 34;
													}
											}
									}
							if (b(eq(_iswall, 0)))
							{
									_player.x = (_player.x + 20);
									}
							}
					if (b(eq(_counter, _num_destination)))
					{
							for (_i = 0; b(lt(_i,29)); _i = (_i + 1)) 
							{
									_winsign[_i].visible = 1;
									}
							}
					}
				break;
			case KeyEvent.VK_UP: {
					_isboxnwall = 0;
					_isboxnbox = 0;
					_iswall = 0;
					_isbox = 0;
					for (_i = 0; b(lt(_i,3)); _i = (_i + 1)) 
					{
							if (b(eq((_player.y - 20), _boxes[_i].y)))
							{
									if (b(eq(_player.x, _boxes[_i].x)))
									{
											_isbox = 1;
											for (_j = 0; b(lt(_j,34)); _j = (_j + 1)) 
											{
													if (b(eq((_boxes[_i].y - 20), _obstacles[_j].y)))
													{
															if (b(eq(_boxes[_i].x, _obstacles[_j].x)))
															{
																	_isboxnwall = 1;
																	_j = 34;
																	}
															}
													}
											if (b(eq(_isboxnwall, 0)))
											{
													for (_j = 0; b(lt(_j,3)); _j = (_j + 1)) 
													{
															if (b(not(eq(_i, _j))))
															{
																	if (b(eq((_boxes[_i].y - 20), _boxes[_j].y)))
																	{
																			if (b(eq(_boxes[_i].x, _boxes[_j].x)))
																			{
																					_isboxnbox = 1;
																					_j = 3;
																					}
																			}
																	}
															}
													if (b(eq(_isboxnbox, 0)))
													{
															for (_j = 0; b(lt(_j,3)); _j = (_j + 1)) 
															{
																	if (b(eq((_boxes[_i].y - 20), _destinations[_j].y)))
																	{
																			if (b(eq(_boxes[_i].x, _destinations[_j].x)))
																			{
																					_counter = (_counter + 1);
																					}
																			}
																	}
															_boxes[_i].y = (_boxes[_i].y - 20);
															_player.y = (_player.y - 20);
															}
													}
											}
									}
							}
					if (b(eq(_isbox, 0)))
					{
							for (_j = 0; b(lt(_j,34)); _j = (_j + 1)) 
							{
									if (b(eq((_player.y - 20), _obstacles[_j].y)))
									{
											if (b(eq(_player.x, _obstacles[_j].x)))
											{
													_iswall = 1;
													_j = 34;
													}
											}
									}
							if (b(eq(_iswall, 0)))
							{
									_player.y = (_player.y - 20);
									}
							}
					if (b(eq(_counter, _num_destination)))
					{
							for (_i = 0; b(lt(_i,29)); _i = (_i + 1)) 
							{
									_winsign[_i].visible = 1;
									}
							}
					}
				break;
			case KeyEvent.VK_DOWN: {
					_isboxnwall = 0;
					_isboxnbox = 0;
					_iswall = 0;
					_isbox = 0;
					for (_i = 0; b(lt(_i,3)); _i = (_i + 1)) 
					{
							if (b(eq((_player.y + 20), _boxes[_i].y)))
							{
									if (b(eq(_player.x, _boxes[_i].x)))
									{
											_isbox = 1;
											for (_j = 0; b(lt(_j,34)); _j = (_j + 1)) 
											{
													if (b(eq((_boxes[_i].y + 20), _obstacles[_j].y)))
													{
															if (b(eq(_boxes[_i].x, _obstacles[_j].x)))
															{
																	_isboxnwall = 1;
																	_j = 34;
																	}
															}
													}
											if (b(eq(_isboxnwall, 0)))
											{
													for (_j = 0; b(lt(_j,3)); _j = (_j + 1)) 
													{
															if (b(not(eq(_i, _j))))
															{
																	if (b(eq((_boxes[_i].y + 20), _boxes[_j].y)))
																	{
																			if (b(eq(_boxes[_i].x, _boxes[_j].x)))
																			{
																					_isboxnbox = 1;
																					_j = 3;
																					}
																			}
																	}
															}
													if (b(eq(_isboxnbox, 0)))
													{
															for (_j = 0; b(lt(_j,3)); _j = (_j + 1)) 
															{
																	if (b(eq((_boxes[_i].y + 20), _destinations[_j].y)))
																	{
																			if (b(eq(_boxes[_i].x, _destinations[_j].x)))
																			{
																					_counter = (_counter + 1);
																					}
																			}
																	}
															_boxes[_i].y = (_boxes[_i].y + 20);
															_player.y = (_player.y + 20);
															}
													}
											}
									}
							}
					if (b(eq(_isbox, 0)))
					{
							for (_j = 0; b(lt(_j,34)); _j = (_j + 1)) 
							{
									if (b(eq((_player.y + 20), _obstacles[_j].y)))
									{
											if (b(eq(_player.x, _obstacles[_j].x)))
											{
													_iswall = 1;
													_j = 34;
													}
											}
									}
							if (b(eq(_iswall, 0)))
							{
									_player.y = (_player.y + 20);
									}
							}
					if (b(eq(_counter, _num_destination)))
					{
							for (_i = 0; b(lt(_i,29)); _i = (_i + 1)) 
							{
									_winsign[_i].visible = 1;
									}
							}
					}
				break;
			}
		}
	};
}
