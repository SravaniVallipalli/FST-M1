def sum(numbers):
    sum=0
    for number in numbers:
        sum+=int(number)
    return sum
listSize1=int(input("enter list size "))
values1=input("enter values: ").split()
result=sum(values1)
print("the sum of numbers in list is ",result)
    