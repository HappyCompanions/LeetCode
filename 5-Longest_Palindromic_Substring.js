'use strict';

class Solution {
	/**
	 * @param {string} s
	 * @param {number} start
	 * @param {number} end
	 */
	_match(s, start, end) {
		let len = 0;
		while (start >= 0 && end <= s.length - 1 && s[start] === s[end]) {
			len++;
			start--;
			end++;
		}
		return len;
	}

	/**
	 * @param {string} s
	 */
	solve(s) {
		if (s.length === 1) {
			return s;
		}
		s = s.split('').join(String.fromCharCode(0x07));
		let dp = new Array(s.length).fill(0);
		let rightMostPalindromeRight = 0;
		let rightMostPalindromeMid = 0;
		for (let i = 1; i < s.length; i++) {
			if (i > rightMostPalindromeRight) {
				dp[i] = this._match(s, i, i);
				continue;
			}

			let mirrorI = rightMostPalindromeMid - (i - rightMostPalindromeMid);
			if (mirrorI - dp[mirrorI] + 1 > rightMostPalindromeMid - dp[rightMostPalindromeMid] + 1) {
				dp[i] = dp[mirrorI];
				rightMostPalindromeMid = i;
				rightMostPalindromeRight = i + dp[i] - 1;
			} else if (mirrorI - dp[mirrorI] + 1 === rightMostPalindromeMid - dp[rightMostPalindromeMid] + 1) {
				dp[i] = dp[mirrorI] + this._match(s, i - dp[mirrorI], i + dp[mirrorI]);
			} else {
				dp[i] = mirrorI - (rightMostPalindromeMid - dp[rightMostPalindromeMid] + 1) + 1;
			}
		}

		let maxPalindromMid = dp.reduce((prev, cur, i, dp) => {
			if (cur > dp[prev]) {
				return i;
			} else if (cur === dp[prev] && s[i] === String.fromCharCode(0x07)) {
				return i;
			} else {
				return prev;
			}
		}, 0);
		return s.slice(maxPalindromMid - dp[maxPalindromMid] + 1, maxPalindromMid + dp[maxPalindromMid]).replace(/[\x07]/g, '');
	}
}

/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
	let sol = new Solution();
	return sol.solve(s);
};

console.log(longestPalindrome('abb'))
