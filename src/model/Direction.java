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
}
