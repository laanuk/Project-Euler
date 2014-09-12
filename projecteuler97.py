x = 1
for a in range (1, 7830458) :
    x = x << 1
    if (x > 10000000000) :
        x -= 10000000000

num = x * 28433 + 1

s = str(num)

print(s[len(s)-10 : len(s)])
