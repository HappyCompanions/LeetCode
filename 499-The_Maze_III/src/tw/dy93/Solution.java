package tw.dy93;

import java.util.PriorityQueue;

/**
 * Created by dy93 on 2017/4/4.
 */


public class Solution {
    public static class Move {
        public int x;
        public int y;
        public String literal;

        private Move(int x, int y, String literal) {
            this.x = x;
            this.y = y;
            this.literal = literal;
        }

        public static Move[] getMoves() {
            Move[] moves = new Move[4];
            moves[0] = new Move(1, 0, "d");
            moves[1] = new Move(0, -1, "l");
            moves[2] = new Move(0, 1, "r");
            moves[3] = new Move(-1, 0, "u");
            return moves;
        }

        @Override
        public String toString() {
            return literal;
        }
    }

    public static class DistanceTableEntry {
        public int cost;
        public String moves;
        public boolean used;

        private DistanceTableEntry() {
            cost = 65535;
            moves = "";
            used = false;
        }

        public static DistanceTableEntry[][] getDistanceTable(int row, int col) {
            DistanceTableEntry[][] table = new DistanceTableEntry[row][];
            for (int i = 0; i < row; i++) {
                table[i] = new DistanceTableEntry[col];
            }

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    table[i][j] = new DistanceTableEntry();
                }
            }
            return table;
        }
    }

    private boolean canMove(int[][] maze, int[] coordinate, int[] moveStep) {
        int newX = coordinate[0] + moveStep[0];
        int newY = coordinate[1] + moveStep[1];
        return newX >= 0 && newX < maze.length &&
                newY >= 0 && newY < maze[0].length &&
                maze[newX][newY] != 1;
    }

    private void showDistanceTable(int[][] maze, DistanceTableEntry[][] distanceTable) {
        for (int i = 0; i < distanceTable.length; i++) {
            for (int j = 0; j < distanceTable[0].length; j++) {
                if (maze[i][j] == 1) {
                    System.out.printf("######|");
                } else {
                    System.out.printf("%6d|", distanceTable[i][j].cost);
                }
            }
            System.out.println();
            for (int j = 0; j < distanceTable[0].length; j++) {
                if (maze[i][j] == 1) {
                    System.out.printf("######|");
                } else {
                    System.out.printf("%6s|", distanceTable[i][j].moves);
                }
            }
            System.out.println();
            for (int j = 0; j < distanceTable[0].length; j++) {
                if (maze[i][j] == 1) {
                    System.out.printf("######|");
                } else {
                    System.out.printf("%6s|", distanceTable[i][j].used ? "T" : "F");
                }
            }
            System.out.println();
            for (int j = 0; j < distanceTable[0].length; j++) {
                System.out.printf("------|");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        DistanceTableEntry[][] distanceTable = DistanceTableEntry.getDistanceTable(maze.length, maze[0].length);
        distanceTable[ball[0]][ball[1]].cost = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] c1, int[] c2) ->
                distanceTable[c1[0]][c1[1]].cost - distanceTable[c2[0]][c2[1]].cost);

        pq.add(new int[]{ball[0], ball[1]});
        Move[] moves = Move.getMoves();
        while (!pq.isEmpty()) {
            int[] startCoor = pq.poll();
            DistanceTableEntry start = distanceTable[startCoor[0]][startCoor[1]];
            //System.out.printf("pick (%d, %d)\n", startCoor[0], startCoor[1]);
            //showDistanceTable(maze, distanceTable);
            if (!start.used) {
                start.used = true;
            } else {
                continue;
            }

            for (Move move : moves) {
                int steps = 1;
                int[] moveStep = new int[]{move.x * steps, move.y * steps};
                int[] coor = new int[]{startCoor[0], startCoor[1]};
                boolean updateWhenBlocked = false;
                while (canMove(maze, startCoor, moveStep)) {
                    updateWhenBlocked = false;
                    coor[0] = startCoor[0] + moveStep[0];
                    coor[1] = startCoor[1] + moveStep[1];

                    if (start.cost + steps <= distanceTable[coor[0]][coor[1]].cost) {
                        distanceTable[coor[0]][coor[1]].cost = start.cost + steps;

                        distanceTable[coor[0]][coor[1]].moves = (!distanceTable[coor[0]][coor[1]].moves.equals("") &&
                                distanceTable[coor[0]][coor[1]].moves.compareTo(start.moves + move.literal) < 0) ?
                                distanceTable[coor[0]][coor[1]].moves :
                                start.moves + move.literal;
                        updateWhenBlocked = true;
                    }

                    steps++;
                    moveStep[0] = move.x * steps;
                    moveStep[1] = move.y * steps;
                }

                // stopped
                if (!distanceTable[coor[0]][coor[1]].used && updateWhenBlocked) {
                    pq.add(new int[]{coor[0], coor[1]});
                }
            }
        }
        //showDistanceTable(maze, distanceTable);
        return distanceTable[hole[0]][hole[1]].moves.equals("") ? "impossible" : distanceTable[hole[0]][hole[1]].moves;
    }


}