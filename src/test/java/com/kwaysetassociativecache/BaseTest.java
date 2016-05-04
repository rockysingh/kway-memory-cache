package com.kwaysetassociativecache;

import com.kwaysetassociativecache.stub.User;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    protected User user1 = new User("joe","bloggs","test@test.com");
    protected User user2 = new User("lisa","roy","roy@lisa.com");
    protected User user3 = new User("rocky","balboa","rocky@gmail.com");
    protected User user4 = new User("andrew","edwards","andrew@edwards.com");
    protected User user5 = new User("5","5","5@email.com");
    protected User user6 = new User("6","6","6@email.com");
    protected User user7 = new User("7","7","7@email.com");
    protected User user8 = new User("8","8","8@email.com");
    protected User user9 = new User("9","9","8@email.com");
    protected User user10 = new User("10","10","8@email.com");
    protected List<User> users = new ArrayList<>();
    
    @Before
    public void setUp(){
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);
        users.add(user10);
    }
    
}
