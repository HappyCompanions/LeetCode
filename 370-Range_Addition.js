/**
 * @param {number} length
 * @param {number[][]} updates
 * @return {number[]}
 */
var getModifiedArray = function (length, updates) {
	let ret = [];
	updates.forEach(([startIndex, endIndex, inc]) => {
		ret[startIndex] = (ret[startIndex] || 0) + inc;
		if (endIndex < length - 1) {
			ret[endIndex + 1] = (ret[endIndex + 1] || 0) - inc;
		}
	})

	let sum = 0;
	for (let i = 0; i < length; i++) {
		sum += (ret[i] || 0);
		ret[i] = sum;
	}
	return ret;
};

let ret = getModifiedArray(10, [[2, 4, 6], [5, 6, 8], [1, 9, -4]])

console.log(ret);