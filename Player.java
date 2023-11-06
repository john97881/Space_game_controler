
public class Player extends SpaceObjects {
	public int initial_x;
	public int initial_y;
	
	private int x_bound;
	private int y_bound;

	public int previous_x;
	public int previous_y;
	
	public int moves = 0;
	
	public Player(int max_x, int max_y, Planet home_planet) {
		this.x_bound = max_x;
		this.y_bound = max_y;
		while (true) {
			this.x = this.random_object.nextInt(max_x + 1);
		    this.y = this.random_object.nextInt(max_y + 1);

		    this.initial_x = this.x;
		    this.initial_y = this.y;
		    
		    if (this.x != home_planet.x || this.y != home_planet.y) {
		    	break;
		    }
		}
	}
	
	public Boolean move(int new_x, int new_y) {
		if (new_x > this.x_bound || new_x < 0) {
			return false;
		}
		if (new_y > this.y_bound || new_y < 0) {
			return false;
		}
		
		this.previous_x = this.x;
		this.previous_y = this.y;
		
		this.x = new_x;
	    this.y = new_y;
	    this.moves++;
	    return true;
	}
	

	public void goBack() {
		this.x = this.previous_x;
		this.y = this.previous_y;
	    this.moves++;
	}
	
}
