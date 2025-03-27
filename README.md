# CS121 Project 10 - Bank on It Pt. 2

We are given the task of programming a Banking program with Administrator and Customer functionality. 

![image](https://github.com/user-attachments/assets/10351009-be44-45a3-9c4c-f312129b9f1b)

## Admin Class
```
class Admin extends User
  ====================
  ====================
    Admin()
    string menu()
    void start()
    string getReport()
  ====================
```

### String menu()
Displays the following menu.
```
Admin Menu

0) Exit this menu
1) Full customer report
2) Add user
3) Apply interest to savings accounts

Action:
```
Waits for user input and stores in menuResponse. Returns menuResponse. 

### Void start()

Is an empty method. 

## Bank Class
```
class Bank implements HasMenu
  ====================
    Admin admin
    ArrayList customers
  ====================
    Bank()
    void main()
    void loadSampleCustomers()
    void saveCustomers()
    void loadCustomers()
    void reportAllUsers()
    void addUser()
    void applyInterest()
    void loginAsCustomer()
    string menu()
    void start()
    void startAdmin()
  ====================
```
### String menu()

Displays the following menu. 
```
Bank Menu

0) Exit system
1) Login as admin
2) Login as customer

Action:
```
Waits for user input. Stores input in menuResponse. Returns menuResponse.

### applyInterest()
```
Use an iterator to step through the array list of customers.
Assign the current iteration of the iterator to currentCustomer.
Call currentCustomer.savings.calcInterest().
```
### void loginAsCustomer()

Ran into an issue with User class login(userName, PIN). I was saying
```
If userName == userName:
    login = true
```
which is always true. I fixed it to be:
```
if this.userName == userName:
    login = true
```

### void startAdmin()

Similar to start() in Menu and Customer. Acts as a traffic controller. 
