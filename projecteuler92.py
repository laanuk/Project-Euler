onechain = [1, 10, 13, 32, 44]
eightyninechain = [85, 145, 42, 20,  4, 16 , 37, 58, 89]
chaincount = 0

def findChain(n) :
    newchain = [n]
    i = 0
    while (1 == 1) :

        if n in onechain :
            if i != 0 :
                onechain.extend(newchain)
            return 0
        if n in eightyninechain :
            if i != 0 :
                eightyninechain.extend(newchain)
            return 1

        s = str(n)
        if i != 0 :
            newchain.append(n)
        n = 0
        for digit in s :
            d = int(digit)
            n += d * d
        i = 1

for x in range(2,568) :
    chaincount += findChain(x)

for x in range (568, 1000000) :
    s = str(x)
    x = 0
    for digit in s :
        d = int(digit)
        x += d * d
    if x in eightyninechain :
        chaincount += 1

print(chaincount)
