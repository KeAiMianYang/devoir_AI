/**
 * BINOME : 
 * Dupuy-roudel Hugo : 21306151
 * Lebert Jasmine : 21301704
 */
package model;
/**
 * Direction represente les directions Nord, Sud, Est, Ouest
 * @author Jasmine
 *
 */
public enum Direction {
	NORTH{

		@Override
		public Direction move_straight() {
			return NORTH;
		}

		@Override
		public Direction move_left() {
			return WEST;
		}

		@Override
		public Direction move_right() {
			return EAST;
		}
		
	},
	SOUTH{

		@Override
		public Direction move_straight() {
			return SOUTH;
		}

		@Override
		public Direction move_left() {
			return EAST;
		}

		@Override
		public Direction move_right() {
			return WEST;
		}
		
	},
	WEST{

		@Override
		public Direction move_straight() {
			return WEST;
		}

		@Override
		public Direction move_left() {
			return SOUTH;
		}

		@Override
		public Direction move_right() {
			return NORTH;
		}
		
	},
	EAST{

		@Override
		public Direction move_straight() {
			return EAST;
		}

		@Override
		public Direction move_left() {
			return NORTH;
		}

		@Override
		public Direction move_right() {
			return SOUTH;
		}
		
	};
	/**
	 * (non utilisé pour le moment) avance d'une case en avant
	 * @return
	 */
	public abstract Direction move_straight();
	/**
	 * (non utilisé pour le moment) avance dans la case à gauche du vaisseau
	 */
	public abstract Direction move_left();
	/**
	 * (non utilisé pour le moment) avance dans la case à droite du vaisseau
	 * @return
	 */
	public abstract Direction move_right();
	public static Direction get_dir(String s) {
		if(s.equals("N")) return Direction.NORTH;
		if(s.equals("S")) return Direction.SOUTH;
		if(s.equals("O")) return Direction.WEST;
		if(s.equals("E")) return Direction.EAST;
		return null;
	}
}
