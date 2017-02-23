#include <queue>

class queue_element {
public:
	queue_element() {}
	queue_element(int r, int c, int dist) : mR(r), mC(c), mDist(dist) {}

	int getRow() const { return mR; }
	int getCol() const { return mC; }
	int getDist() const { return mDist; }

	bool operator<(const queue_element& qe) const {
		//priority queue in reverse order
		return mDist > qe.getDist();
	}

private:
	int mR, mC, mDist;
};

class Solution {
public:
	const int INFINITE = 2 << 20;

	void initialize(vector<vector<int>>& maze)
	{
		mazeRow = maze.size();
		mazeCol = maze[0].size();
		minDist = new int*[mazeRow];
		used = new bool*[mazeRow];

		for (int i = 0; i < mazeRow; ++i) {

			minDist[i] = new int[mazeCol];
			used[i] = new bool[mazeCol];

			for (int j = 0; j < mazeCol; ++j) {
				minDist[i][j] = INFINITE;
				used[i][j] = false;
			}

		}
	}

	int solve(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {

		priority_queue <queue_element> pq;
		int destR = destination[0], destC = destination[1];
		const int dr[4] = { 0, 0, 1, -1 }, dc[] = { 1, -1, 0, 0 };
		auto thisPtr = this;
		auto validGrid = [&thisPtr](int r, int c) { return r >= 0 && r < thisPtr->mazeRow && c >= 0 && c < thisPtr->mazeCol; };

		minDist[start[0]][start[1]] = 0;
		pq.push(queue_element(start[0], start[1], 0));

		//dijkstra
		while (!pq.empty()) {
			queue_element qe = pq.top();
			pq.pop();

			if (destR == qe.getRow() && destC == qe.getCol()) {
				break;
			}

			if (false == used[qe.getRow()][qe.getCol()]) {
				used[qe.getRow()][qe.getCol()] = true;
			}
			else {
				continue;
			}

			for (int dir = 0; dir < 4; ++dir) {
				int newr = qe.getRow() + dr[dir], newc = qe.getCol() + dc[dir];

				if (validGrid(newr, newc) && 0 == maze[newr][newc]) {
					int newCost = minDist[qe.getRow()][qe.getCol()]+1;

					//distance estimation
					int forEstR = newr+dr[dir], forEstC = newc+dc[dir], preR = newr, preC = newc;
					while (validGrid(forEstR, forEstC) && 0 == maze[forEstR][forEstC]) {
						++newCost;
						preR = forEstR;
						preC = forEstC;
						forEstR += dr[dir];
						forEstC += dc[dir];
					}
					if (newCost < minDist[preR][preC]) {
						minDist[preR][preC] = newCost;
						pq.push(queue_element(preR, preC, newCost));
					}
				}
			}
		}

		if (INFINITE == minDist[destR][destC])
			return -1;

		return minDist[destR][destC];
	}

	int shortestDistance(vector<vector<int>>& maze, vector<int>& start, vector<int>& destination) {
		initialize(maze);
		return solve(maze, start, destination);
	}

private:
	int **minDist;
	bool **used;
	int mazeRow, mazeCol;
};