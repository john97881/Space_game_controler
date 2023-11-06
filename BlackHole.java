import java.util.LinkedList;

public class BlackHole extends SpaceObjects {
	
	public BlackHole(int max_x, int max_y, Planet home_planet, Player user_player, LinkedList<BlackHole> black_holes) {
		Boolean keep_iterating = true;
		while (keep_iterating) {
			keep_iterating = false;
			this.x = this.random_object.nextInt(max_x + 1);
		    this.y = this.random_object.nextInt(max_y + 1);
		    
		    if (this.x == home_planet.x && this.y == home_planet.y) {
		    	keep_iterating = true;
		    }
		    
		    if (this.x == user_player.x && this.y == user_player.y) {
		    	keep_iterating = true;
		    }
		    
		    for (int black_hole_index = 0; black_hole_index < black_holes.size(); black_hole_index++) { 
	            int bh_x = black_holes.get(black_hole_index).x;
	            int bh_y = black_holes.get(black_hole_index).y;
	            if (this.x == bh_x && this.y == bh_y) {
	            	keep_iterating = true;
			    }
	        }
		}
	}
	
	public Boolean playerCollides(Player user_player) {

	    if (this.x == user_player.x && this.y == user_player.y) {
	    	user_player.goBack();
	    	return true;
	    }
	    return false;
	}
	
}
