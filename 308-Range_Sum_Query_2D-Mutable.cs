public class ValueChangeInformation
{
    public int row;
    public int col;
    public int val;
    public int oriVal;

    public ValueChangeInformation (int row, int col, int val, int oriVal)
    {
        this.row = row;
        this.col = col;
        this.val = val;
        this.oriVal = oriVal;
    }
}

public class NumMatrix
{
    private int[,] mSum;
    List<ValueChangeInformation> changeInfoList;
    public NumMatrix(int[,] matrix)
    {
        changeInfoList = new List<ValueChangeInformation>();
        mSum = new int[matrix.GetLength(0), matrix.GetLength(1)];
        for (int i = 0; i < matrix.GetLength(0); ++i)
        {
            int accumulation = 0;
            for (int j = 0; j < matrix.GetLength(1); ++j)
            {
                accumulation += matrix[i, j];
                mSum[i, j] = accumulation;
                if (0 != i) mSum[i, j] += mSum[i - 1, j];
            }
        }
    }

    public void Update(int row, int col, int val)
    {
        int oriValue = SumRegion(row, col, row, col);
        changeInfoList.Add(new ValueChangeInformation(row, col, val, oriValue));
    }

    public int SumRegion(int row1, int col1, int row2, int col2)
    {
        int result = mSum[row2,col2];
        --row1;
        --col1;

        if (0 <= row1)
        {
            result -= mSum[row1, col2];
        }

        if (0 <= col1)
        {
            result -= mSum[row2, col1];
        }

        if (0 <= row1 && 0 <= col1)
        {
            result += mSum[row1,col1];
        }

        foreach (ValueChangeInformation valChangeInfo in changeInfoList)
        {
            if (valChangeInfo.row <= row2 && valChangeInfo.row > row1 &&
                valChangeInfo.col <= col2 && valChangeInfo.col > col1)
            {
                result -= valChangeInfo.oriVal;
                result += valChangeInfo.val;
            }
        }

        return result;
    }
}