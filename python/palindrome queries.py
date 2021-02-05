'''
@Author: rishi
'''
n, m = list(map(int, input().split()))
s = input()
for i in range(m):
    check, k, x = input().split()
    if int(check) == 1:
        s = s[:int(k)-1] + x + s[int(k):]
    else:
        temp = s[int(k) - 1:int(x)]
        # print(temp)
        print("YES") if temp == temp[::-1] else print("NO")




