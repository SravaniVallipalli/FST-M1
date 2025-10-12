listSize=int(input("enter list size"))
values=input("enter values: ").split()
sum=0
for i in range(len(values)):
    sum=sum+int(values[i])

print(sum)    
