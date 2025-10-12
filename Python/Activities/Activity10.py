listSize1=int(input("enter list size"))
values1=input("enter values: ").split()
for value in values1:
    if(int(value)%5==0):
        print(value)
        