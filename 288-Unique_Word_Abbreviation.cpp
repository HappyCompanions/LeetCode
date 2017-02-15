class ValidWordAbbr {
public:
    ValidWordAbbr(vector<string> dictionary) {
        for(string str: dictionary) {
            map[ToAbbr(str)].insert(str);
        }
    }
    
    bool isUnique(string word) {
        string abbr = ToAbbr(word);
        if (map.end() == map.find(abbr))
            return true;
        if (map[abbr].count(word) == map[abbr].size())
            return true;
        return false;
    }
    
    string ToAbbr(string str) {
        int length = str.length();
        if (2 >= length)
            return str;
        else {
            return str[0] + to_string(length-2) + str[length-1];
        }
    }

    unordered_map<string, unordered_set<string>> map;
};

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * bool param_1 = obj.isUnique(word);
 */
