public class Planet extends SpaceObjects {
	public int initial_x;
	public int initial_y;
	
	public Planet(int max_x, int max_y) {
	    this.x = this.random_object.nextInt(max_x + 1);
	    this.y = this.random_object.nextInt(max_y + 1);
	    this.initial_x = this.x;
	    this.initial_y = this.y;
	}
	

	public Boolean playerCollides(Player user_player) {
	    if (this.x == user_player.x && this.y == user_player.y) {
	    	return true;
	    }
	    return false;
	}
	
	public double distance(int x1, int y1, int x2, int y2) {
	    return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}
	
	public String indicator(Player user_player) {
		double previous_distance = distance(this.x, this.y, user_player.previous_x, user_player.previous_y);
		double current_distance = distance(this.x, this.y, user_player.x, user_player.y);
	    if (current_distance < previous_distance) {
			return "You are now on location ("+user_player.x+","+user_player.y+") and you have moved closer to the home planet.";
	    } else { 
			return "You are now on location ("+user_player.x+","+user_player.y+") and you have moved further from the home planet.";
	    }
	     
	}
	
}
