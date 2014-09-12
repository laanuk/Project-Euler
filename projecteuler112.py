#all of 1-99 is bouncy
#write algorithm to find next non-bouncy numbers
#start at point 21780 there are 19602 bouncy numbers at this point
#the ratio is 90 percent at this point
notbouncy = 2178
for x in range(21781, 10000000) :
    b = str(x)
    c = []
    for digit in b:
        c.append (int(digit))
    d = sorted(c)

    if (c == d) :
        notbouncy += 1
    elif (c[::-1] == d) :
        notbouncy += 1

    if (notbouncy * 100 == x) :
        print(x)
        break

print(notbouncy)
