# Vending Machine

Vending machine app challenge

## Instructions (In the java ide of choice)

1. Main run: `src/main/java/com/seanmayer/o/vendingmachine/OVendingMachine.java`

## Application Details

### Design

MVC pattern has been applied to divide console interface, buisness logic (controller) and data structures (pojos).

State pattern has also been applied to represent different states of a vending machine, such as: amount of change inputted, inventory, item selected, change inserted etc. Each state will return varying results depending on the what state is active.

To note, there is some refactoring needed to integrate the design patterns outlined fully above, although almost did!. Notably, where sepeartion of concerns would need addressing and also fully implementing the state pattern, the state pattern was not applied when handling the change making problem, although with more time I would address this in the next iteration. :)

### Simulator

If you want to play around with the inventory or change within the machine this can be found here:

`./src/main/java/simulator`

