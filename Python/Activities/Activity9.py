listSize1=int(input("enter list size"))
values1=input("enter values: ").split()
listSize2=int(input("enter list size"))
values2=input("enter values: ").split()

thirdList=[]
for value in values1:
    if(int(value)%2==0):
        thirdList.append(int(value))

for value in values2:
    if(int(value)%2!=0):
        thirdList.append(int(value))
print(thirdList)        