class Vector2D {
public:
    Vector2D(vector<vector<int>>& vec2d) {
        ptr = &vec2d;
        row = 0;
        col = 0;
    }

    int next() {
        return (*ptr)[row][col++];
    }

    bool hasNext() {
        
        if (row == ptr->size()) {
            return false;
        }
        
        if (col == (*ptr)[row].size()) {
            row++;
            col = 0;
            return hasNext();
        }
        
        if (row < ptr->size() && col < (*ptr)[row].size()) {
            return true;
        } else {
            return false;
        }
    }
    
    int row, col;
    vector<vector<int>> *ptr;
};
