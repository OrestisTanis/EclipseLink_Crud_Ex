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
        services.UserImpl userService = new services.UserImpl();
        
        // Perform the CRUD operations via the userService object
        User user = userService.findById(1);
        if (user == null){
            System.out.println("Oops. The requested user was not found.");
        } 
        else {
            System.out.println(user);
        }
        
        
        List<User> users = userService.findAll();
         if (users.size() == 0){
            System.out.println("Oops. No users were found.");
        } 
        else {
            for (User u : users){
                System.out.println(u);
            }
        }        
           
    }

}
