#!/usr/bin/python
from collections import deque
from operator import add


class SnakeGame(object):
    def __init__(self, width, height, food):
        """
        Initialize your data structure here.
        @param width - screen width
        @param height - screen height
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1],
        the second is at [1,0].
        :type width: int
        :type height: int
        :type food: List[List[int]]
        """
        self.width = width
        self.height = height
        self.food = list(reversed(food))
        self.body = deque([[0, 0]])
        self.actions = {
            'U': [-1, 0],
            'L': [0, -1],
            'R': [0, 1],
            'D': [1, 0],
        }

    def move(self, direction):
        """
        Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
        @return The game's score after the move. Return -1 if game over.
        Game over when snake crosses the screen boundary or bites its body.
        :type direction: str
        :rtype: int
        """
        new_head = map(add, self.actions[direction], self.body[-1])
        if self.food and new_head == self.food[-1]:
            self.body.append(new_head)
            self.food.pop()
        elif (new_head in self.body or new_head[0] in [-1, self.height] or
                new_head[1] in [-1, self.width]) and new_head != self.body[0]:
            return -1
        else:
            self.body.append(new_head)
            self.body.popleft()
        return len(self.body) - 1


# Your SnakeGame object will be instantiated and called as such:
# obj = SnakeGame(width, height, food)
# param_1 = obj.move(direction)
obj = SnakeGame(3, 2, [[1, 2], [0, 1]])
print(obj.move('R'))
print(obj.move('D'))
print(obj.move('R'))
print(obj.move('U'))
print(obj.move('L'))
print(obj.move('U'))
#  output: 0, 0, 1, 1, 2, -1
