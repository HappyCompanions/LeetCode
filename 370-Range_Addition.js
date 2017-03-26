/**
 * @param {number} length
 * @param {number[][]} updates
 * @return {number[]}
 */
var getModifiedArray = function (length, updates) {
	updates = updates.map(([startIndex, endIndex, inc]) => {
		return [[startIndex, inc], [endIndex+1, -inc]];
	}).reduce((prev, cur) => {
		return prev.concat(cur);
	}, []).sort((a, b) => a[0] - b[0]);

	let sum = 0;
	let updateLength = updates.length;
	let ret = [];
	for (let i = 0, j = 0; i < length; i++) {
		while (j < updateLength && i == updates[j][0]) {
			sum += updates[j][1];
			j++;
		}
		ret.push(sum);
	}
	return ret;
};