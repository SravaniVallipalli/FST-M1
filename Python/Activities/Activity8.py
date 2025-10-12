listSize=int(input("enter list size"))
values=input("enter values: ").split()
firstNum=values[0]
lastNum=values[-1]
if(firstNum==lastNum):
    print("first and last are equal")
else:
    print("first and last are not equal")    