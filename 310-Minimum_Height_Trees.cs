using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCode310
{
    public class Solution
    {
        List<int>[] adjaList;
        List<int> candidates, nextCandidates;
        bool[] nodeRemoved;
        int[] neighborCount;

        public void leafNeighborProcess(int now)
        {
            foreach (int neighbor in adjaList[now])
            {
                --neighborCount[neighbor];
                if (1 == neighborCount[neighbor] && false == nodeRemoved[neighbor])
                {
                    nextCandidates.Add(neighbor);
                }
            }
        }

        public IList<int> FindMinHeightTrees(int n, int[,] edges)
        {
            List<int> ret = new List<int>();
            int remain = n;

            adjaList = new List<int>[n];
            nodeRemoved = new bool[n];
            candidates = new List<int>();
            neighborCount = new int[n];

            for (int i = 0; i < n; ++i)
            {
                adjaList[i] = new List<int>();
            }

            for (int i = 0; i < edges.GetLength(0); ++i)
            {
                adjaList[edges[i, 0]].Add(edges[i, 1]);
                adjaList[edges[i, 1]].Add(edges[i, 0]);
                ++neighborCount[edges[i, 0]];
                ++neighborCount[edges[i, 1]];
            }

            //initialization
            if (remain > 2)
            {
                for (int i = 0; i < n; ++i)
                {
                    if (1 == neighborCount[i])
                    {
                        candidates.Add(i);
                    }
                }
            }

            while (remain > 2)
            {
                nextCandidates = new List<int>();
                foreach (int node in candidates)
                {
                    --remain;
                    nodeRemoved[node] = true;
                    leafNeighborProcess(node);
                }
                candidates = nextCandidates;
            }

            for (int i = 0; i < n; ++i)
                if (false == nodeRemoved[i])
                {
                    ret.Add(i);
                }
            return ret;
        }
    }

    class LeetCode310
    {
        public static void Main()
        {
        }
    }
}
