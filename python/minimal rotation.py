'''
@Author: rishi
'''

inp = input()
rotations = []

for i in range(len(inp)):
    temp = inp[i:] + inp[:i]
    rotations.append(temp)
rotations.sort()
print(rotations[0])