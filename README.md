# TMPS_LAB1

Topic: Cars
Author: Turcan Catalin

#Theory
I used three patterns: Singleton, Builder, Abstract Factory. 

Singleton: Restricts the creation of a class to a single instance, and provides access to that single instance. I used it to create a Car Shop. Only 1 car shop is allowed to exist so that we can correctly count at any time the number of sold cars and/or revenue.

Abstract Factory: Lets you select a specific factory implementation from a family of possible factories. I use it to get prices for the cars, so that the revenue of the shop can be calculated. 

Builder: Used to create a complex object using simple objects. It gradually constructs a car from smaller parts. I use it to build a car from 3 other parts (body, engine, wheels).

#Implementation
