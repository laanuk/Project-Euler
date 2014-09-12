import gc

gc.disable()
a = [1]
b = [1]
c = [1, 2]
d = [1, 2, 3]
e = [1, 3, 4, 5]
f = [1, 3, 5, 6, 7]
combs = [a, b, c, d, e, f]


mil = 1000000
def findposs(n) :
    numarr = [1]
    nextnum = 1
    for i in range((n - 2), 1, -1) :
        if i > (n - i) :
            nextnum = (nextnum + combs[i][n - i - 1]) % mil
            numarr.append(nextnum)
        else :
            nextnum = (nextnum + combs[i][i - 1]) % mil
            numarr.append(nextnum)
    nextnum = (nextnum + 1) % mil
    numarr.append(nextnum)
    numarr.append(nextnum + 1)
    combs.append(numarr)
    print(n)
    if (nextnum + 1 == mil) :
        return -1


for i in range(6, 1000) :
    if findposs(i) == -1 :
        print("FOUND IT AT")
        print(i)
        break;
print(combs[len(combs)-1])
