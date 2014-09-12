numinputs = int(input("enter inputs"))
numchildren = int(input("numchildren"))
candyList = []
differences = []

for i in range(numinputs):
    candyList.append(int(input()))

candyList.sort()
print(candyList)

for x in range(numchildren -1, numinputs):
    differences.append(candyList[x] - candyList[x-(numchildren-1)])

print(min(differences))
