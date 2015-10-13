package model;

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
	
	public abstract Direction move_straight();
	public abstract Direction move_left();
	public abstract Direction move_right();
}
