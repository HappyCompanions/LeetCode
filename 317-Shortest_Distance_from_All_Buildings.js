/**
 * @param {number[][]} grid
 * @return {number}
 */
var minTotalDistance = function (grid) {
	let xLine = new Array(grid.length).fill(0);
	let yLine = new Array(grid[0].length).fill(0);

	let points = [];
	for (let i = 0, len = grid.length; i < len; i++) {
		for (let j = 0, len = grid[0].length; j < len; j++) {
			if (grid[i][j] === 1) {
				points.push([i, j]);
				xLine[i]++;
				yLine[j]++;
			}
		}
	}

	// find midX
	let mid = Math.ceil(points.length / 2)
	let midX = 0;
	for (let i = 0, len = xLine.length; i < len; i++) {
		if (mid <= xLine[i]) {
			midX = i;
			break;
		} else {
			mid -= xLine[i];
		}
	}
	// find midY
	mid = Math.ceil(points.length / 2)
	let midY = 0;
	for (let i = 0, len = yLine.length; i < len; i++) {
		if (mid <= yLine[i]) {
			midY = i;
			break;
		} else {
			mid -= yLine[i];
		}
	}

	let totalDistance = 0;
	points.forEach(([x, y]) => {
		totalDistance += Math.abs(x - midX) + Math.abs(y - midY);
	});

	return totalDistance;
};

// result = 49
let result = minTotalDistance([[0, 1], [0, 1], [0, 1], [1, 1], [0, 0], [0, 1], [0, 0], [0, 0], [0, 0], [0, 0], [1, 0], [1, 0], [0, 0], [0, 0], [1, 1], [0, 0]]);
console.log(result);

// let result = minTotalDistance([[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]);
// console.log(result);