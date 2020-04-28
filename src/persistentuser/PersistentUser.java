package persistentuser;

import entities.User;
import java.util.List;

/**
 *
 * @author Walter
 */
public class PersistentUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
            CRUD operations
            - findById(long id)
            - findAll()
            - save(User user)  // insert into
            - update(long id, User user)   // update
            - delete(long id)
            
        */
        
        // Instantiate  userService object
        // Perform the CRUD operations via the userService object
        services.UserImpl userService = new services.UserImpl();
        
        // Read
        User user = userService.findById(1);
        if (user == null){
            System.out.println("Oops. The requested user was not found.");
        } 
        else {
            System.out.println(user);
        }
        
        // Read all
        List<User> users = userService.findAll();
         if (users.size() == 0){
            System.out.println("Oops. No users were found.");
        } 
        else {
            for (User u : users){
                System.out.println(u);
            }
        }   
        
        // Create
//        User newUser = new User("John", "Abruzzi", "1234567890", "abruzzi@gmail.com");
//        userService.save(newUser);
        
        // Update
        User updatedUser = new User("Brad", "Bellick", "0987654321", "bellick@yahoo.us");
        userService.updateById(2, updatedUser);
        
        // Delete
        int i = 1;
        boolean delete = userService.deleteById(i);
        if (delete){
            System.out.println("User with id: " + i + " deleted successfully.");
        }
        else {
            System.out.println("No user was found with id=" + i);
        }
    }

}
