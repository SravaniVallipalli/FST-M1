def sum(n):
    if n<=1:
        return n
    else:
        return n+sum(n-1)
input=int(input("enter num"))    
print("sum of num is " ,sum(input))    
