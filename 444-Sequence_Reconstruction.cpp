class Solution {
public:

    bool answer, specialCaseOK;
    vector <int> *adja;
    vector <int> candidates, nextCandidates;
    int *predeCnt;

    bool sequenceReconstruction(vector<int>& org, vector<vector<int>>& seqs) {
        int N = org.size();
        vector <int> ansSeq;

        answer = true;
        specialCaseOK = false;
        adja = new vector <int> [N];
        predeCnt = new int[N];
        memset(predeCnt, 0, N*sizeof(int));
        //constructing graph
        for (auto &seq_vec : seqs) {
            for (int i = 0; i < seq_vec.size(); ++i) {
                if (seq_vec[i] > N || seq_vec[i] < 1) {
                    answer = false;
                    break;
                }

                if (i+1 < seq_vec.size()) {
                    if (seq_vec[i+1] > N || seq_vec[i+1] < 1) {
                        answer = false;
                        break;
                    }
                    adja[seq_vec[i]-1].push_back(seq_vec[i+1]-1);
                    ++predeCnt[seq_vec[i+1]-1];
                }
            }
            if (1 == seq_vec.size() && 1 == seq_vec[0]) specialCaseOK = true;
            if (false == answer) break;
        }

        /*
        dumbass testcase
        [5,3,2,4,1]
        [[5,3,2,4],[4,1],[1],[3],[2,4]
        [1,1000000000]]
        -------------------
        [1]
        [[1,-9],[-9,-8],[-8,-9]]
        -------------------
        [1]
        [] : false ===> (pointless Testcase lol)
        -------------------
        [1]
        [[],[]] : false ===> (pointless Testcase lol)
        -------------------
        [1]
        [[1],[1],[1]] : ture
        -------------------
        [1]
        [[1,1]] : false (lol)
        */
        if (false == answer) return false;
        if (1 == org.size()) return specialCaseOK; //special case : super pointless

        for (int i = 0; i < N; ++i) {
            if (0 == predeCnt[i])
                candidates.push_back(i);
        }


        while (true) {

            if (candidates.size() != 1) {
                answer = false;
                break;
            }

            int now = candidates.back();
            nextCandidates.clear();
            ansSeq.push_back(now+1);

            if (ansSeq.size() == org.size()) break;

            for (int i = 0; i < adja[now].size(); ++i) {
                int nextv = adja[now][i];
                --predeCnt[nextv];
                if (0 == predeCnt[nextv]) {
                    nextCandidates.push_back(nextv);
                }
            }

            candidates = nextCandidates;
        }

        if (ansSeq != org)
            return false;

        return answer;
    }
};