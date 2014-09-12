n = int(input())

def genFib() :
    fibList = [1, 1]
    a = 1
    b = 1
    nextFib = 2

    while nextFib < 10**10 :
        nextFib = a + b
        fibList.append(nextFib)
        a = b
        b = nextFib

    fibList.remove(nextFib)
    return fibList

fibList = genFib()

def checkFib(inputnum):
    for item in fibList:
        if item == inputnum:
            print("IsFibo")
            return
    print("IsNotFibo")

for x in range(n):
    n = int(input())
    checkFib(n)
