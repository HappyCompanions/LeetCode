'use strict';
class Solution {
	/**
	 * @param {number[]} nums
	 */
	constructor(nums) {
		this._nums = nums;
		this._sums = new Array(nums.length).fill(0);
		this._sums[0] = nums[0];
		for (let i = 1; i < this._sums.length; i++) {
			this._sums[i] = this._sums[i - 1] + nums[i];
		}
		this._cache = {};
	}

	/**
	 * @param {number} start, included
	 * @param {number} end, included
	 */
	_sum(start, end) {
		if (start === 0) {
			return this._sums[end];
		}
		return this._sums[end] - this._sums[start - 1];
	}

	/**
	* @param {number} start
	* @param {number} target
	* @param {number} depth
	*/
	solve(start = 0, target = -1, cuts = 0) {
		if (cuts === 3) {
			return this._sum(start, this._sums.length - 1) === target;
		}

		for (let i = start; i < this._nums.length; i++) {
			// skip continuous zero sucks
			if (i !== start && this._nums[i] === 0 && this._nums[i - 1] === 0 && this._nums[i + 1] === 0) {
				continue;
			}
			let ok = false;
			if (cuts === 0) {
				ok = this.solve(i + 2, this._sum(0, i), 1);
			} else if (this._sum(start, i) === target) {
				ok = this.solve(i + 2, target, cuts + 1);
			}
			if (ok) {
				return ok;
			}
		}
		return false;
	}
}


/**
 * @param {number[]} nums
 * @return {boolean}
 */
var splitArray = function (nums) {
	let sol = new Solution(nums);
	return sol.solve();
};
