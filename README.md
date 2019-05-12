The program requires java and maven to run.
You can quickly set up and run the project with 'mvn:spring-boot:run'

The application is set to run on port 5012. 
You may need to update the application.properties file in src/main/resources/ to use your mysql credentials
(Current using 'root' as the username and 'password' as the password)
The database used must be named 'facebook' (can also change this in the application.properties file)

There are two premade account: Greg, Greg2

Both accounts have their passwords set as 'greg'

The 'Greg' account has a post made with an image, while the 'Greg2' has one without.

There is also a group, "Greg's group" that can be found under the groups tab.

The two accounts are not friends with each other.

Currently supports:
* Friends
* Groups
* Image uploads
* Registration
* Logins
(Password are hashed in bcrypt)
