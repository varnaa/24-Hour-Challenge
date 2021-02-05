'''
@Author: rishi
'''

s = input()
n = int(input())
for i in range(n):
    pattern = input()
    print("YES") if pattern in s else print("NO")