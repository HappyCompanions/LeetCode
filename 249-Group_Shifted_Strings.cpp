class Solution {
public:
    vector<vector<string>> groupStrings(vector<string>& strings) {
        vector<vector<string>> ret;
        map<pair<int,string>, vector<string>> classifyList;

        for(string s : strings) {
            int size = s.size();
            string delta = "";

            getCharDelta(s, delta);
            auto key = make_pair(size, delta);
            classifyList[key].push_back(s);
        }
        
        for(auto it : classifyList) {
            ret.push_back(it.second);
        }

        return ret;
    }
private:
    void getCharDelta(string input, string &delta) {
        if (input.size() == 0 || input.size() == 1) {
            delta = "0";
            return;
        }
        
        int temp;
        stringstream ss("");
        for(int i = 0; i < (input.size()-1); ++i) {
            temp = input[i+1] - input[i];
            temp = (temp+26) % 26;
            ss << temp << endl;
        }
        delta = ss.str();
    }
};
