//don't forget to always put your package name here
package Runner;

import Models.User;
import Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Components of the type CommandLineRunner are called right after
 * the application start up. So the method *run* is called as soon as
 * the application starts.
 */
@Component
public class CmdRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... strings) throws Exception {

        User u1 = createUser("user::0001", "Perry", "Manson", "perry.mason@acme.com", "Who can we get on the case?");
        userRepository.save(u1);

        User u2 = createUser("user::0002", "Major", "Tom", "major.tom@acme.com", "Send me up a drink");
        userRepository.save(u2);


        User u3 = createUser("user::0003", "Jerry", "Wasaracecardriver", "jerry.wasaracecardriver@acme.com", "el sob number one");
        userRepository.save(u3);

        Optional<User> user = userRepository.findById("user::0001");
        System.out.println("User found = "+user.get().getName());

        List<User> result = (List<User>) userRepository.findByTelNo("%@acme.com");

        System.out.println( "Total of @acme.com users = "+result.size()  );

    }

    public static User createUser(String firstName, String lastName,
                                  String tcno, String telno,String password) {
        User user = new User();

        user.setName(firstName);
        user.setSurname(lastName);
        user.setTcNo(tcno);
        user.setTelNo(telno);
        user.setPassword(password);
        return user;
    }

}