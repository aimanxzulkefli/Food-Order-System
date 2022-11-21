# Food-Order-System

Java GUI project that cover Java components and connection into database.

A system that show how food is order from counter till it ready to delivery. Start from customer choose their favourite food
and quantity that they like. Transfer customer order into MS Access database. Finally show progress of the order to customer until 
it reach them.

## Link to video tutorial

## Installation

For this project I use Visual Studio Code to write my code. There is other better platform that offer better setup for 
Java project such as Eclipse where they provided windowbuilder that make it more easier to code GUI project. But to get 
comfortable using Visual Studio Code i decided to code here.

1.  Install Visual Studio Code
2.  Copy the source code
3.  Paste into the platform 
4.  Run

Then the program should start as below ⬇️

![image](https://user-images.githubusercontent.com/92250985/202934734-4562edd0-5213-4fab-8c3d-e6a0de62bd93.png)

## Walkthrough

When you run the program first things u need to do is pick the the food that you want. For this example i will pick
"Salad Burger" and then click submit.

![image](https://user-images.githubusercontent.com/92250985/202935477-aa8b4519-693e-4798-92a0-f1d9e3dbd38a.png)

After that you will need to set a quantity for the food you oick earlier. Let set the quantity to "3" this time and press
submit button.

![image](https://user-images.githubusercontent.com/92250985/202935629-8ac4f0bd-0d54-4a7b-8b21-e42fc9ee2ca4.png)

As soon the program able to connect with the MS Access database below prompt will display that say "Record Added".

![image](https://user-images.githubusercontent.com/92250985/202935944-14f5c046-5c9e-4a18-b1bd-c7b2543e9406.png)

Then we can check our MS Access database to confirm the record. Focus on ID 63, that is the record we insert.

![image](https://user-images.githubusercontent.com/92250985/202936032-403e42ab-5e77-4655-a3a3-24b57af97ba5.png)

Then the progress of the order will be shown as below.

1.  Blue - means it in the process
2.  Green - process complete
3.  White - not yet started

![image](https://user-images.githubusercontent.com/92250985/202936065-3a2ea04b-45e8-4d63-98e0-35d8002420a3.png)

When all the progress bar turn green it means all the work are completed. Then the below prompt will be shown before program close.

![image](https://user-images.githubusercontent.com/92250985/202936143-da09d60c-581b-4429-bc57-a422b5872323.png)













