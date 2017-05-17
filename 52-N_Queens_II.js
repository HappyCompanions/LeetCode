'use strict'
/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function (n) {
	if (n === 1) {
		return 1;
	} else if (n < 4) {
		return 0;
	}

	const board = []
	for (let i = 0; i < n; i++) {
		board.push(new Array(n).fill(0));
	}

	/**
	 * @param {Array<Array<number>>} board
	 * @param {number} n
	 * @param {number} row
	 */
	function dfs(board, n, row) {
		let possible = 0;
		for (let col = 0; col < n; col++) {
			if (board[row][col] === 0) {
				if (row == n - 1) {
					possible += 1;
				} else {
					for (let r = Math.max(row - col, 0); r <= Math.min(row + -col + n - 1, n - 1); r++) {
						board[r][r - row + col]++
					}
					for (let r = Math.max(row + col + 1 - n, 0); r <= Math.min(row + col, n - 1); r++) {
						board[r][row + col - r]++
					}
					for (let r = 0; r < n; r++) {
						board[r][col]++
					}
					for (let c = 0; c < n; c++) {
						board[row][c]++
					}
					board[row][col] -= 3;

					possible += dfs(board, n, row + 1);

					for (let r = Math.max(row - col, 0); r <= Math.min(row + -col + n - 1, n - 1); r++) {
						board[r][r - row + col]--
					}
					for (let r = Math.max(row + col + 1 - n, 0); r <= Math.min(row + col, n - 1); r++) {
						board[r][row + col - r]--
					}
					for (let r = 0; r < n; r++) {
						board[r][col]--
					}
					for (let c = 0; c < n; c++) {
						board[row][c]--
					}
					board[row][col] += 3;
				}
			}
		}
		return possible;
	}
	return dfs(board, n, 0);
};