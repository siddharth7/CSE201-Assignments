Implement a basic web application to handle online orders of a restaurant that sells pizzas. The web pages should handle the customer end and the restaurant manager end. So you will need separate servlets handling the two categories of user profiles as described below.
Customer View:
Customers could create a new order or track their placed order. So the first page should provide the user with these two options.
 For Option: Create new order
On creating a new order the system should generate an order id which the user would use to
track the placed order in future.
Once the id is generated and displayed to the user, he/she should be displayed a menu-a short one containing about 4 varieties of pizzas with 3 sizes available. Add appropriate check boxes for the user to select the item and a field to input the quantity of each(set default to 1 which would be considered only if the checkbox is checked). It would be even better if you could add images for every item.
On clicking submit, the webpage should navigate to another form asking the user to enter his name, contact number and address as mandatory fields.
You must maintain the session(maintain order id and selected items) while the previous page navigates to this page and display your order id on the top of the page.
On entering the personal details the user should be able to navigate to the tracking page of his/her order indicating the progress till Order Placed.
States possible(transition possible in the same order): Order Placed, Preparation, Bake, Quality Check, Out for delivery, Delivered
    
 For Option: Track my order
Customer should be prompted to enter the order id. On submitting it, the webpage
displaying the progress with the stage should be displayed.
Restaurant Managerial view:
The user should be able to view all the pending(undelivered) orders and their state in tabular form, with an update button corresponding to each row. On clicking the update, the order the stage of that order should increment to the next stage.
System:
The system should maintain the status of every order at the backend(maybe in a file) to be able to update and track the current status.
Bonus: Perform a DoS attack on the system by overwhelming the system with requests. Submit your implementation along with this assignment.
