/**
 * Encodes a list of strings to a single string.
 *
 * @param {string[]} strs
 * @return {string}
 */
var encode = function(strs) {
    strs.push('0~0');
    return strs.join('@%!%@');
};

/**
 * Decodes a single string to a list of strings.
 *
 * @param {string} s
 * @return {string[]}
 */
var decode = function(s) {
    result = s.split('@%!%@');
    result.pop();
    return result;
};

/**
 * Your functions will be called as such:
 * decode(encode(strs));
 */
