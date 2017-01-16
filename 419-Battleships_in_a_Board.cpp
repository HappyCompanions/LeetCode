class Solution {
public:

    int validGrid(int rowNum, int colNum, int r, int c)
    {
        return r >= 0 && r < rowNum && c >= 0 && c < colNum;
    }

    int countBattleships(vector<vector<char>>& board) {
        int result = 0;
        int rowNum = board.size(), colNum = board[0].size();
        const char constantBattleShip = 'X';

        for (int r = 0; r < rowNum; ++r) {
            for (int c = 0; c < colNum; ++c) {
                if (constantBattleShip == board[r][c]) {//counting head only
                    if ( (!validGrid(rowNum, colNum, r-1, c) || constantBattleShip != board[r-1][c]) &&
                         (!validGrid(rowNum, colNum, r, c-1) || constantBattleShip != board[r][c-1]) ) {
                             ++result;
                         }
                }
            }
        }

        return result;
    }
};