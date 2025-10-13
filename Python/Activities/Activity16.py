class car:
    def __init__(self,manufacturer,model,make,transmission,color):
        self.manufacturer=manufacturer
        self.model=model
        self.make=make
        self.transmission=transmission
        self.color=color

    def accelerate(self):
        print("hello manufacturer is " +self.manufacturer+ ", car is moving " +self.model)  
    def stop(self):
        print("hello manufacturer is " +self.manufacturer+ ", car is moving " +self.model)    
car1=car("audi","a6",2025,"co2","black")
car2=car("bmw","bm",2024,"co","white")
car3=car("hundai","creta","2025","co2","red")
car1.accelerate()
car2.stop()