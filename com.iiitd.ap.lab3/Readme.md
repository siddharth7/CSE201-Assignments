
Your task is to design a basic social network. The network consists of various Persons as represented by a Person class. Your Person class should support
1. user login and logout,
2. adding friends from the network,
3. listing friends associated with a Person,
4. listing mutual friends between two Person objects,
5. getting the Person’s display name,
6. updating the Person’s display name
 Note that, features 2,3,4 and 6 require the Person to be logged in else you should prompt him/her to login and then it should proceed with the requested method.
 You are not required to design any GUI. Use the console to take username and password inputs while logging in.
 Take care of the access modifier while defining the fields and methods. For instance, the username and password fields must be private and not object should be able to directly infer what the correct credentials are by calling p.password where p is an object of Person. Refer to the javadocs provided for the expected modifiers.
 To manage the login, you are required to check for authenticity and track Person object’s login status i.e logged in or logged out. A class called Login_details should manage that and every Person class should use an object of this Login_details class.
 Incase of incorrect credentials, your methods should throw an Exception called Incorrect_Credentials_Exception. You have to create this exception class and you should define it in the same file as Login_details.java
 So you are required to submit two files Login_details.java and Person.java
 The javadocs for these two classes have been provided for your reference. Check the
respective htmls at this path: doc\com\iiitd\ap\lab3
 The main method provided makes use of a HashMap that stores the network details of every person and his relation with the rest of the network.
HashMap<Integer, String> hmap = new HashMap<Integer, String>();
creates hashmap with key of Integer type and value of String type
The Hashmap variable used is global_map. It would be used even in the person class. For instance, it would be needed to determine while adding a friend to someone’s friendlist whether that person exists in the network or not. You may have guessed the need to make this hashmap variable as static- as all Person objects share this common network.
Sample of how the program should proceed for the scenario provided in the main method:
Harsh expected to be logged in Please enter your username: har
Please enter your password: har123
Siddharth expected to be logged in Please enter your username:
sid
Please enter your password:
 HashMap maintains key and value pairs and is often denoted as HashMap<Key, Value> or
 HashMap<K, V>. The key and value may be of any datatype. Example,
sid
Friends of Siddharth:[Amit, Mutual friends of Siddharth Mutual friends of Siddharth
Samit, Harsh]
and Harsh:[Amit, Samit]
and Amit:[Harsh]
