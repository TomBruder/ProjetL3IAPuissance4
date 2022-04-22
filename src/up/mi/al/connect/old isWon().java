public int isWon() {
		int res = 0;
		// checks columns
		for (int[] column : board) {
			res = 0;
			for (int t : column) {
				if (t == 0) {
					res = 0;
					break;
				}
				if ((t < 0 && res >= 0) || (t > 0 && res <= 0)) {
					res = t;
				} else {
					res += t;
					if (Math.abs(res) >= linkSize )
						return res;
				}
			}
		}
		
		//check rows
		for (int i = this.height - 1; i >= 0 ; i--) {
			res = 0;
			for (int j = 0; j < this.width; j++) {
				if ((board[j][i] < 0 && res > 0) || (board[j][i] > 0 && res < 0)) {
					res = board[j][i];
				} else {
					res += board[j][i];
					if (Math.abs(res) >= linkSize)
						return res;
				}
			}
		}

/*		for (int i = linkSize - 1; i < this.width + (this.height - linkSize) -1; i++) {
			res = 0;
			for (int j = Math.max(0, i - (this.width - 1)); j <= Math.min(this.height-1, i); j++) {
				if (board[i - j][j] == 0)
					res = 0;
				if ((board[i - j][j] < 0 && res >= 0) || (board[i - j][j] > 0 && res <= 0)) {
					res = board[i - j][j];
				} else {
					res += board[i - j][j];
					if (Math.abs(res) >= linkSize)
						return res;
				}
			}
		}

		for (int i = linkSize ; i <= this.width + (this.height - linkSize) -1; i++) {
			res = 0;
			int i2 = this.width - i;
			for (int j = Math.max(0, -i2); j <= Math.min(this.height-1, i-1); j++) {
				if (board[i2 + j][j] == 0)
					res = 0;
				if ((board[i2 + j][j] < 0 && res >= 0) || (board[i2 + j][j] > 0 && res <= 0)) {
					res = board[i2 + j][j];
				} else {
					res += board[i2 + j][j];
					if (Math.abs(res) >= linkSize)
						return res;
				}
			}
		}*/
		
		for (int i = 0; i < this.width + linkSize - 1; i++) {
			res = 0;
			for (int j = 0; j < this.height; j++) {
				try {
					if (board[i - j][j] == 0)
						res = 0;
					if ((board[i - j][j] < 0 && res >= 0) || (board[i - j][j] > 0 && res <= 0)) {
						res = board[i - j][j];
					} else {
						res += board[i - j][j];
						if (Math.abs(res) >= linkSize)
							return res;
					}
				}
				catch (IndexOutOfBoundsException e) {
					res = 0;
				}
			}
		}
		
		for (int i = this.width + linkSize - 1; i >= 0; i--) {
			res = 0;
			for (int j = 0; j < this.height; j++) {
				try {
					if (board[i + j][j] == 0)
						res = 0;
					if ((board[i + j][j] < 0 && res >= 0) || (board[i + j][j] > 0 && res <= 0)) {
						res = board[i + j][j];
					} else {
						res += board[i + j][j];
						if (Math.abs(res) >= linkSize)
							return res;
					}
				}
				catch (IndexOutOfBoundsException e) {
					res = 0;
				}
			}
		}

		return 0;
	}

	// old code
	/*
	 * for (int i = linkSize - 1; i < this.width + (this.height - linkSize); i++) {
	 * res = 0; for (int j = Math.max(0, i - (this.width - 1)); j <=
	 * Math.min(this.height-1, i); j++) { if (board[i - j][j] == 0) res = 0; if
	 * ((board[i - j][j] < 0 && res >= 0) || (board[i - j][j] > 0 && res <= 0)) {
	 * res = board[i - j][j]; } else { res += board[i - j][j]; if (Math.abs(res) >=
	 * linkSize) return res; } } }
	 * 
	 * for (int i = linkSize - 1 ; i < this.width + (this.height - linkSize); i++) {
	 * res = 0; int i2 = (this.width - i) - 1 ; for (int j = Math.max(0, i -
	 * (this.width - 1)); j <= Math.min(this.height-1, i); j++) { if (board[i2 +
	 * j][j] == 0) res = 0; if ((board[i2 + j][j] < 0 && res >= 0) || (board[i2 +
	 * j][j] > 0 && res <= 0)) { res = board[i2 + j][j]; } else { res += board[i2 +
	 * j][j]; if (Math.abs(res) >= linkSize) return res; } } }
	 * 
	 * return 0; }
	 */