def fibanocci(number):
    if number<=1:
        return number
    else:
        return fibanocci(number-1)+fibanocci(number-2)
value=int(input("enter a number "))
if value<0:
    print("please enter a positive value")
else:
    print("fibanocci series")
    for i in range(value):
        print(fibanocci(i))      