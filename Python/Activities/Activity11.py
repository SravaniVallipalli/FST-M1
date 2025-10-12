fruit_dict={
    "apple":"280",
    "mango":"300",
    "orange":"150"
}
input=input("enter fruit name ").lower()
if(input in fruit_dict):
    print("fruit is available")
else:
    print("fruit is not available")    