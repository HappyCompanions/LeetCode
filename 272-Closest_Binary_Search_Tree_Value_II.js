'use strict';
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} target
 * @param {number} k
 * @return {number[]}
 */
var closestKValues = function (root, target, k) {
	/**
	 * This method returns index of the search key, if it is contained in the array, else it returns (-(insertion point) - 1).
	 * @param {number[]} ary
	 * @param {number} target
	 */
	const binarySearch = (ary, target) => {
		let start = 0
		let end = ary.length - 1;

		while (start <= end) {
			let mid = (start + end) >> 1;
			if (ary[mid] < target) {
				start = mid + 1;
			} else if (target < ary[mid]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -start - 1;
	}

	const nodes = [];
	const traverse = (root) => {
		if (root.left !== null) {
			traverse(root.left);
		}
		nodes.push(root.val);
		if (root.right !== null) {
			traverse(root.right);
		}
	}
	traverse(root);

	let i = binarySearch(nodes, target);
	// if target not in nodes, determine the closest i
	if (i < 0) {
		i = -i - 1;
		if (i !== nodes.length) {
			i = Math.abs(nodes[i - 1] - target) < Math.abs(nodes[i] - target) ? i - 1 : i;
		} else {
			i = nodes.length - 1
		}
	}
	const ans = [nodes[i]];
	let left = i - 1;
	let right = i + 1;
	while (left >= 0 && right <= nodes.length - 1 && ans.length < k) {
		ans.push(target - nodes[left] > nodes[right] - target ? nodes[right++] : nodes[left--]);
	}

	while (left >= 0 && ans.length < k) {
		ans.push(nodes[left--]);
	}

	while (right <= nodes.length - 1 && ans.length < k) {
		ans.push(nodes[right++]);
	}

	return ans;
};
